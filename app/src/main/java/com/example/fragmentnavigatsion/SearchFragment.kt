package com.example.fragmentnavigatsion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.ImageAdapter
import com.example.adapter.UsersAdapter
import com.example.adapter.VideoAdapter
import com.example.api.ApiService
import com.example.api.baseResponse.BaseResponse
import com.example.fragmentnavigatsion.databinding.FragmentSearchBinding
import com.example.test.model.ImageModel
import com.example.test.model.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment() {

    lateinit var binding : FragmentSearchBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadUsers()
        loadImage()
        loadVideos()
    }
    private fun loadUsers() {
        ApiService.apiImage().getImage().enqueue(object : Callback<BaseResponse<List<ImageModel>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<ImageModel>>>,
                response: Response<BaseResponse<List<ImageModel>>>,
            ) {
                binding.rvUsers.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.rvUsers.adapter = UsersAdapter(response.body()?.hits ?: listOf())
            }

            override fun onFailure(call: Call<BaseResponse<List<ImageModel>>>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun loadImage() {
        ApiService.apiImage().getImage().enqueue(object : Callback<BaseResponse<List<ImageModel>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<ImageModel>>>,
                response: Response<BaseResponse<List<ImageModel>>>,
            ) {
                binding.rvImages.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.rvImages.adapter = ImageAdapter(response.body()?.hits ?: listOf())
            }

            override fun onFailure(call: Call<BaseResponse<List<ImageModel>>>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun loadVideos() {
        ApiService.apiPexels().getVideos().enqueue(object : Callback<BaseResponse<List<Model>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<Model>>>,
                response: Response<BaseResponse<List<Model>>>,
            ) {
                binding.rvVideos.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.rvVideos.adapter = VideoAdapter(response.body()?.hits ?: listOf())
            }


            override fun onFailure(call: Call<BaseResponse<List<Model>>>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }


}