package com.example.bishkekrielt.ui.home
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bishkekrielt.R
import com.example.bishkekrielt.data.common.BaseFragment
import androidx.lifecycle.Observer
import com.example.bishkekrielt.MainActivity
import com.example.bishkekrielt.databinding.FragmentHomeBinding
import com.example.bishkekrielt.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(){

    var binding: FragmentHomeBinding? = null
   // override fun resID() = R.layout.fragment_home
    private val vm by viewModel<HomeViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return  binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpDb()
        vm.getData()
    }

    private fun setUpDb(){
        vm.sys.observe(viewLifecycleOwner, {
            binding?.text1Home?.text = it.country
        })

    }

}