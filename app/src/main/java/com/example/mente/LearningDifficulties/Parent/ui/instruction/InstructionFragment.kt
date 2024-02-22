package com.example.mente.Parent.ui.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.mente.R
import com.example.mente.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {
    private lateinit var binding: FragmentInstructionBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imageListDiff = ArrayList<SlideModel>()
        imageListDiff.add(SlideModel(R.drawable.diff_1))
        imageListDiff.add(SlideModel(R.drawable.diff_2))
        imageListDiff.add(SlideModel(R.drawable.diff_3))
        imageListDiff.add(SlideModel(R.drawable.diff_4))
        imageListDiff.add(SlideModel(R.drawable.diff_5))
        imageListDiff.add(SlideModel(R.drawable.diff_6))
        imageListDiff.add(SlideModel(R.drawable.diff_7))


        val imageListAdhd = ArrayList<SlideModel>()
        imageListAdhd.add(SlideModel(R.drawable.adhd_1))
        imageListAdhd.add(SlideModel(R.drawable.adhd_2))
        imageListAdhd.add(SlideModel(R.drawable.adhd_3))
        imageListAdhd.add(SlideModel(R.drawable.adhd_4))
        imageListAdhd.add(SlideModel(R.drawable.adhd_5))
        imageListAdhd.add(SlideModel(R.drawable.adhd_6))
        imageListAdhd.add(SlideModel(R.drawable.adhd_7))


        val imageListAutism = ArrayList<SlideModel>()
        imageListAutism.add(SlideModel(R.drawable.autism_1))
        imageListAutism.add(SlideModel(R.drawable.autism_2))
        imageListAutism.add(SlideModel(R.drawable.autism_3))
        imageListAutism.add(SlideModel(R.drawable.autism_4))
        imageListAutism.add(SlideModel(R.drawable.autism_5))
        imageListAutism.add(SlideModel(R.drawable.autism_6))
        imageListAutism.add(SlideModel(R.drawable.autism_7))


        val imageList = when(testType){
            "adhd" -> imageListAdhd
            "autism" -> imageListAutism
            else -> imageListDiff
        }


        binding.sliderImage.setImageList(imageList , ScaleTypes.CENTER_CROP)
    }

    companion object {
        var testType = ""
    }
}