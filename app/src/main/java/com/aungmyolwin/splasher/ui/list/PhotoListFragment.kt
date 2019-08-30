package com.aungmyolwin.splasher.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungmyolwin.splasher.R
import com.aungmyolwin.splasher.vo.Result
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_photo_list.*
import javax.inject.Inject

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

class PhotoListFragment : DaggerFragment() {
    private val adapter = PhotoAdapter()

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_photo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModels = ViewModelProviders.of(this, vmFactory).get(PhotoListViewModels::class.java)

        initAdapter()

        viewModels.photos.observe(this, Observer {
            when (it) {
                is Result.Success -> adapter.setPhotos(it.data)
            }

        })

    }

    private fun initAdapter() {
        rv_photo_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_photo_list.adapter = adapter
    }

}