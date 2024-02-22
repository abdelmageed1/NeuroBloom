package com.example.mente.Autism.Specialist.ui

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
import com.example.mente.databinding.FragmentAutismResultBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.tensorflow.lite.DataType
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

const val MODEL_FILE = "model.tflite"
class AutismResultFragment : Fragment() {

    lateinit var binding : FragmentAutismResultBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(modelInput.isNotEmpty()){
            modelDeployment()
        }else{
            Toast.makeText(context, "Input Error", Toast.LENGTH_SHORT).show()
        }

        binding.goHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_autismResultFragment_to_parentAutismFragment)
        }


        binding.goToRecButton.setOnClickListener {
            InstructionFragment.testType = "autism"
            findNavController().navigate(R.id.action_autismResultFragment_to_instructionFragment)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
            performAction()
        }
        callback.isEnabled = true

        setHasOptionsMenu(true)
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
        findNavController().navigate(R.id.action_autismResultFragment_to_parentAutismFragment)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAutismResultBinding.inflate(inflater,container,false)
        return binding.root
    }



     private fun modelDeployment() {

        CoroutineScope(Dispatchers.IO).launch {
            // Load the model file
            val model =
                FileUtil.loadMappedFile(this@AutismResultFragment.requireContext(), MODEL_FILE)
            // Create an interpreter with one thread
            val interpreter = Interpreter(model, Interpreter.Options().apply {
                setNumThreads(1)
            })
            // Get the input and output tensor shapes
//            val inputShape = interpreter.getInputTensor(0).shape()
            val outputShape = interpreter.getOutputTensor(0).shape()

            val inputData = modelInput

            // Create a byte buffer with the size of your input data
            val dataType = interpreter.getInputTensor(0).dataType()
            // dynamic byte size per element
            val buffer = ByteBuffer.allocate(inputData.size * dataType.byteSize())

            // Create a byte buffer with the size of your input data
//            val buffer = ByteBuffer.allocate(inputData.size * 8) // 8 bytes per int

            // Write your input data to the buffer using a loop
            for (value in inputData.indices) {
                buffer.putLong(inputData[value].toLong())
            }
            // Rewind the buffer position to zero
            buffer.rewind()
            // Create an output object with the right shape and type
            val output = TensorBuffer.createFixedSize(outputShape, DataType.FLOAT32)
            // Run the inference
//            interpreter.run(buffer, output.buffer)
            // Use a suspend function to run the inference
            runInference(interpreter, buffer, output.buffer)
            interpreter.close()
//            get the output array
            val outputArray = output.floatArray
            val intArray = outputArray.map { it.toInt() }

            withContext(Dispatchers.Main) {
                val hasOrNot = if (intArray[0] == 0) getString(R.string.modelResultYes) else getString(R.string.modelResultNo)
                binding.autismResultText.text = hasOrNot
//                binding.autismResultText.text = "$modelInput\n" + "$intArray\n"
                binding.goToRecButton.visibility = if (intArray[0] == 0) View.VISIBLE else View.GONE
//                modelInput.clear()
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