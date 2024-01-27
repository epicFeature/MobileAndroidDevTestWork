package com.ntpro.mobileandroiddevtestwork

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ntpro.mobileandroiddevtestwork.databinding.FragmentMainBinding
import de.codecrafters.tableview.TableDataAdapter
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val data = arrayOf(arrayOf("1", "2", "3", "4", "5"), arrayOf("6", "7", "8", "9", "10"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tableView.dataAdapter = SimpleTableDataAdapter(this.requireContext(), data) as TableDataAdapter<Any>
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}