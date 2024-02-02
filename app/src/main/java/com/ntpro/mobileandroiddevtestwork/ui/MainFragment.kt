package com.ntpro.mobileandroiddevtestwork.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ntpro.mobileandroiddevtestwork.view.DealTableDataAdapter
import com.ntpro.mobileandroiddevtestwork.domain.Server
import com.ntpro.mobileandroiddevtestwork.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private val dealTableDataAdapter: DealTableDataAdapter by lazy {
        DealTableDataAdapter(
            requireContext(),
            arrayListOf()
        )
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tableView.dataAdapter = dealTableDataAdapter
        Server().subscribeToDeals {
            dealTableDataAdapter.data.addAll(
                it.sortedWith(
                    compareByDescending(
                        Server.Deal::timeStamp
                    )
                )
            )
            dealTableDataAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}