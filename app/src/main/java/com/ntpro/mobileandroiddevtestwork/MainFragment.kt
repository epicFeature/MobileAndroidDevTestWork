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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val server = Server()
        val data = mutableListOf<Server.Deal>()
        server.subscribeToDeals { data }
        val dealTableDataAdapter = DealTableDataAdapter(this.requireContext(), data)
    }



    /* final SortableCarTableView carTableView = (SortableCarTableView) findViewById(R.id.tableView);
        if (carTableView != null) {
            final CarTableDataAdapter carTableDataAdapter = new CarTableDataAdapter(this, DataFactory.createCarList(), carTableView);
            carTableView.setDataAdapter(carTableDataAdapter);
            carTableView.addDataClickListener(new CarClickListener());
            carTableView.addDataLongClickListener(new CarLongClickListener());
            carTableView.setSwipeToRefreshEnabled(true);
            carTableView.setSwipeToRefreshListener(new SwipeToRefreshListener() {
                @Override
                public void onRefresh(final RefreshIndicator refreshIndicator) {
                    carTableView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final Car randomCar = getRandomCar();
                            carTableDataAdapter.getData().add(randomCar);
                            carTableDataAdapter.notifyDataSetChanged();
                            refreshIndicator.hide();
                            Toast.makeText(MainActivity.this, "Added: " + randomCar, Toast.LENGTH_SHORT).show();
                        }
                    }, 3000);
                }
            });*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}