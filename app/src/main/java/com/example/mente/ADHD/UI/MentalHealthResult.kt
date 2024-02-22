package com.example.mente.ADHD.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mente.Parent.ui.instruction.InstructionFragment
import com.example.mente.R
import com.example.mente.databinding.FragmentMentalHealthResultBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.tensorflow.lite.DataType
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

const val MODEL_FILE = "adhd_model.tflite"

class MentalHealthResult : Fragment() {

    private lateinit var binding: FragmentMentalHealthResultBinding
    private var resultIndex = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            performAction()
        }
        callback.isEnabled = true

        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (modelInput.isNotEmpty()) {
            adhdModelDeployment()
        } else {
            Toast.makeText(context, "Input Error", Toast.LENGTH_SHORT).show()
        }

        binding.goHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_mentalHealthResult_to_parentAdhdFragment)
        }

        binding.goToRecButton.setOnClickListener {
             InstructionFragment.testType = "adhd"
            findNavController().navigate(R.id.action_mentalHealthResult_to_instructionFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMentalHealthResultBinding.inflate(inflater, container, false)
        return binding.root
    }


    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Perform the desired action when the back button is pressed
                performAction()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun performAction() {
        findNavController().navigate(R.id.action_mentalHealthResult_to_parentAdhdFragment)
    }


    private fun adhdModelDeployment() {

        CoroutineScope(Dispatchers.IO).launch {
            // Load the model file
            val model =
                FileUtil.loadMappedFile(this@MentalHealthResult.requireContext(), MODEL_FILE)
            // Create an interpreter with one thread
            val interpreter = Interpreter(model, Interpreter.Options().apply {
                setNumThreads(1)
            })
            // Get the input and output tensor shapes
            val outputShape = interpreter.getOutputTensor(0).shape()

            val inputData = modelInput
//            val inputData = mutableListOf(24,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0)

            // Create a byte buffer with the size of your input data
            val dataType = interpreter.getInputTensor(0).dataType()
            // dynamic byte size per element
            val buffer = ByteBuffer.allocate(inputData.size * dataType.byteSize())

            // Write your input data to the buffer using a loop
            for (value in inputData.indices) {
                buffer.putLong(inputData[value].toLong())
            }
            // Rewind the buffer position to zero
            buffer.rewind()
            // Create an output object with the right shape and type
            val output = TensorBuffer.createFixedSize(outputShape, DataType.FLOAT32)
            // Use a suspend function to run the inference
            runInference(interpreter, buffer, output.buffer)
            interpreter.close()
//            get the output array
            val outputArray = output.floatArray
            val intArray = outputArray.map { it.toInt() }

            withContext(Dispatchers.Main) {
                resultIndex = intArray.indexOf(1)
                val disorder = when (resultIndex) {
                    0 -> " اضطراب نقص الانتباه وفرط النشاط لدى البالغين (ADHD)"
                    1 -> "اضطراب طيف التوحد (ASD)"
                    2 -> "الشعور بالوحدة (Loneliness)"
                    3 -> "اضطراب الاكتئاب الشديد (MDD)"
                    4 -> "اضطراب الوسواس القهري (OCD)"
                    5 -> "اضطراب النمو الشامل (PDD)"
                    6 -> "اضطراب ما بعد الصدمة (PTSD)"
                    7 -> "قلق (Anxiety)"
                    8 -> "ثنائي القطب (Bipolar)"
                    9 -> "اضطراب الطعام (Eating Disorder)"
                    10 -> "الاكتئاب الذهاني (Psychotic Depression)"
                    else -> "اضطراب النوم (Sleeping Disorder)"
                }
                val hasNot = getString(R.string.adhd_result_no) + disorder
                val hasDisorder =
                    if (resultIndex == 0) getString(R.string.adhd_result_yes) else hasNot
//                binding.mentalResultText.text = "${modelInput}\n $intArray\n ${intArray.indexOf(1)} \n $disorder"
                binding.mentalResultText.text = hasDisorder
                binding.goToRecButton.visibility = if (resultIndex == 0) View.VISIBLE else View.GONE
                modelInput.clear()

            }
        }
    }


    // Create a suspend function that wraps the interpreter.run call
    private suspend fun runInference(
        interpreter: Interpreter,
        input: ByteBuffer,
        output: ByteBuffer
    ) {
        // Use withContext to switch to the default dispatcher for CPU-intensive task
        withContext(Dispatchers.Default) {
            interpreter.run(input, output)
        }
    }


    companion object {
        var modelInput = mutableListOf<Int>()
    }

}