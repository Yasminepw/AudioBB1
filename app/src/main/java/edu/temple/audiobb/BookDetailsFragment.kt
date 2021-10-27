package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"

class BookListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookList: BookList
    private lateinit var bookViewModel: BookVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bookList = it.getSerializable(ARG_PARAM1) as BookList
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_book_list, container, false)

        bookViewModel = ViewModelProvider(requireActivity()).get(BookVM::class.java)

        recyclerView = layout.findViewById(R.id.bookListFragmentRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = BookAdapter(bookList) {
                position ->  myOnClick(position)
        }
        recyclerView.adapter = adapter

        return layout
    }

    private fun myOnClick(position: Int) {
        (activity as EventInterface).selectionMade()
        bookViewModel.setBook(bookList.get(position))
    }

    companion object {
        @JvmStatic
        fun newInstance(bookList: BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, bookList)
                }
            }

    }

    interface EventInterface {
        fun selectionMade()
    }
}