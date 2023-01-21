package com.example.fragmentnavigatsion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.PexelsAdapter
import com.example.api.ApiService
import com.example.api.baseResponse.BasePexelsResponse
import com.example.fragmentnavigatsion.databinding.FragmentSettingBinding
import com.example.model.ModelList
import com.example.model.Pexels
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadPexels()
    }

    private fun loadPexels() {
        ApiService.apiPexels().getPexelsImage()
            .enqueue(object : Callback<List<ModelList>>{
                override fun onResponse(
                    call: Call<List<ModelList>>,
                    response: Response<List<ModelList>>,
                ) {
                    binding.rvPexels.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                    binding.rvPexels.adapter = PexelsAdapter(response.body() ?: listOf())
                }
                override fun onFailure(call: Call<List<ModelList>>, t: Throwable) {
                    Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
    }
}