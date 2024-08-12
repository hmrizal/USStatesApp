package com.example.usstatesapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usstatesapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var stateAdapter: StateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        stateAdapter = StateAdapter(emptyList()) { state ->
            // Handle state click, navigate to MapActivity
            startActivity(MapActivity.newIntent(this, state))
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = stateAdapter
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            fetchStates()
        }

        fetchStates()
    }

    private fun fetchStates() {
        binding.progressBar.visibility = View.VISIBLE
        ApiService.create().getStates().enqueue(object : Callback<StateResponse> {
            override fun onResponse(call: Call<StateResponse>, response: Response<StateResponse>) {
                binding.progressBar.visibility = View.GONE
                binding.swipeRefreshLayout.isRefreshing = false
                if (response.isSuccessful) {
                    val states = response.body()?.data?.map { stateData ->
                        State(stateData.State, stateData.Population, stateData.Year)
                    } ?: emptyList()
                    stateAdapter.updateStates(states)
                } else {
                    // Handle error
                    Toast.makeText(this@MainActivity, "Error fetching data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<StateResponse>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                binding.swipeRefreshLayout.isRefreshing = false
                // Handle failure
                Toast.makeText(this@MainActivity, "Network error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}