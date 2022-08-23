package com.example.weatherapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapi.R
import com.example.weatherapi.adapters.WeatherAdapter
import com.example.weatherapi.adapters.WeatherModel
import com.example.weatherapi.databinding.FragmentHoursBinding


class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel(
                "",
                "12:00",
                "sunny",
                "30C",
                "",
                "",
                "",
                ""
            ),
            WeatherModel(
                "",
                "13:00",
                "sunny",
                "32C",
                "",
                "",
                "",
                ""
            ),
            WeatherModel(
                "",
                "14:00",
                "sunny",
                "33C",
                "",
                "",
                "",
                ""
            )
        )
        adapter.submitList(list)
    }

    companion object {

        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}