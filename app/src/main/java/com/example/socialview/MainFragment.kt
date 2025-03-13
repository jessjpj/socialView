package com.example.socialview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.socialview.views.adapters.Person
import com.example.socialview.views.adapters.PersonAdapter
import com.example.socialview.databinding.FragmentMainBinding
import com.example.socialview.utils.Mention
import com.hendraanggrian.appcompat.socialview.widget.SocialAutoCompleteTextView

class MainFragment : BaseBottomSheetDialogFragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var customMentionAdapter: ArrayAdapter<Person>
    var mentionField: SocialAutoCompleteTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            customMentionAdapter = PersonAdapter(context = requireContext())
            if (isAdded) {
                Mention.createMention(requireContext(), customMentionAdapter as PersonAdapter)
            }
            mentionField = etMessage.findViewById(R.id.etMessage)
            mentionField!!.mentionAdapter = customMentionAdapter
        }
    }
}