package com.fpassos.marvelapp.ui.characterslist

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fpassos.marvelapp.databinding.CharacterListItemBinding
import com.fpassos.marvelapp.model.data.MarvelCharacter
import com.fpassos.marvelapp.ui.BindingViewHolder
import com.fpassos.marvelapp.ui.Listing

class CharacterListAdapter(
        private val listing: Listing<MarvelCharacter>,
        lifecycleOwner: LifecycleOwner,
        itemCallback: DiffUtil.ItemCallback<MarvelCharacter>
) : PagedListAdapter<MarvelCharacter, BindingViewHolder<CharacterListItemBinding>>(itemCallback) {

    var onItemClicked: ((MarvelCharacter) -> Unit)? = null

    private var status: Listing.Status? = null

    init {
        listing.pagedList.observe(lifecycleOwner, Observer {
            submitList(it)
        })
        listing.status.observe(lifecycleOwner, Observer {
            status = it
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<CharacterListItemBinding> {
        val binding = CharacterListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<CharacterListItemBinding>, position: Int) {
        if (status == Listing.Status.STATUS_LOADING) {
            return
        }

        val character = getItem(position)
        holder.binding.character = character

        character?.let {
            holder.binding.root.setOnClickListener { _ ->
                onItemClicked?.invoke(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (status != Listing.Status.STATUS_LOADING) {
            super.getItemCount()
        } else {
            listing.pageSize
        }
    }
}