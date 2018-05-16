package com.example.mukhlasin.cbddamkar.adaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mukhlasin.cbddamkar.R;
import com.example.mukhlasin.cbddamkar.utils.HistoryData;

import java.util.List;

public class ListHistoryAdapter extends RecyclerView.Adapter<ListHistoryAdapter.ListHistoryViewHolder> {


    private List<HistoryData> allHistory;
    private final ListHistoryAdapterListener onClickListener;

    class ListHistoryViewHolder extends RecyclerView.ViewHolder {
        TextView judul, lokasi;
        LinearLayout recyclerViewHistoryItem;

        ListHistoryViewHolder(View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judulLaporan);
            recyclerViewHistoryItem = itemView.findViewById(R.id.historyItem);
            lokasi = itemView.findViewById(R.id.lokasi);

            recyclerViewHistoryItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.recyclerViewHistoryOnClick(v, getAdapterPosition());
                }
            });

        }
    }

    public ListHistoryAdapter(Context context, List<HistoryData> historyDataList, ListHistoryAdapterListener listener) {
        this.allHistory = historyDataList;
        this.onClickListener = listener;
    }

    @NonNull
    @Override
    public ListHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item_list, parent, false);
        return new ListHistoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHistoryViewHolder holder, int position) {
        HistoryData history = allHistory.get(position);
        holder.judul.setText(history.getJudul());
        holder.lokasi.setText(history.getLokasi());
    }

    public interface ListHistoryAdapterListener {
        void recyclerViewHistoryOnClick(View v, int position);
    }

    @Override
    public int getItemCount() {
        return allHistory.size();
    }
}
