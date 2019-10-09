package com.example.tom.reclamacao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tecnico on 09/07/2015.
 */
public class ReclamacaoAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<Reclamacao> mReclamacao;

    public ReclamacaoAdapter(Context mContext, ArrayList<Reclamacao> mReclamacaos) {
        this.mContext = mContext;
        this.mReclamacao = mReclamacaos;
    }


    @Override
    public int getCount() {
        return mReclamacao.size();
    }

    @Override
    public Object getItem(int position) {
        return mReclamacao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_reclama, parent, false);
        ((TextView) v.findViewById(R.id.txtreclama)).setText(mReclamacao.get(position).getReclamacao());
        if (mReclamacao.get(position).getInfra().equals("S")) {
            v.findViewById(R.id.imginfra).setVisibility(View.VISIBLE);
        } else {
            v.findViewById(R.id.imginfra).setVisibility(View.INVISIBLE);
        }

        if (mReclamacao.get(position).getDocente().equals("S")) {
            v.findViewById(R.id.imgdocente).setVisibility(View.VISIBLE);
        } else {
            v.findViewById(R.id.imgdocente).setVisibility(View.INVISIBLE);
        }


        return v;
    }
}
