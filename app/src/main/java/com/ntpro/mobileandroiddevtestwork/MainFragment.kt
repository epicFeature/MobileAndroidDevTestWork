package com.ntpro.mobileandroiddevtestwork

import android.icu.util.LocaleData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ntpro.mobileandroiddevtestwork.databinding.FragmentMainBinding
import de.codecrafters.tableview.TableDataAdapter
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter
import java.time.LocalDate

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var dealTableDataAdapter: DealTableDataAdapter

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
        viewModel.subScribe {
            val dealTableDataAdapter = DealTableDataAdapter(this.requireContext(), it)
            binding.tableView.dataAdapter = dealTableDataAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}