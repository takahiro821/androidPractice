import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.apple.janken.R

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // 独自に作成したListener
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val itemTextView: TextView = view.findViewById(R.id.itemTextView)
    val itemImageView: ImageView = view.findViewById(R.id.itemImageView)

    init {
        // layoutの初期設定するときはココ
    }

}
