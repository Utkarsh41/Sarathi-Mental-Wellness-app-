package com.utkarsh.scientific.sarathi.selfHelpBooksPack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.utkarsh.scientific.sarathi.R;

import java.util.Locale;

import io.grpc.lb.v1.LoadBalancerGrpc;

public class SelfHelpBooks extends AppCompatActivity {

    RecyclerView mRecyclerView;
    DatabaseReference databaseReference;

    ProgressBar progressBar;

    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_help_books);
        displayPdfs();

    }
    private void displayPdfs() {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("selfHelpBooks");
        mRecyclerView = findViewById(R.id.myRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        query = databaseReference.orderByChild("filename");
        //we will request the files with the filename, if filename exists then it will show in the recyclerView
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    progressBar.setVisibility(View.GONE);
                    showPdf();
                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(SelfHelpBooks.this, ":", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
    private void showPdf() {
//        Context context;
        FirebaseRecyclerOptions<BookModel> options = new FirebaseRecyclerOptions.Builder<BookModel>()
                .setQuery(query, BookModel.class)
                .build();
        FirebaseRecyclerAdapter<BookModel, Adapter> adapter = new FirebaseRecyclerAdapter<BookModel, Adapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Adapter holder, int position, @NonNull BookModel model) {

//                progressBar.setVisibility(View.GONE);
                holder.bookTitle.setText(model.getBookName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(model.getBookUrl()), "application/pdf");
                        startActivity(Intent.createChooser(intent, "Choose an Application:"));
                    }
                });

            }

            @NonNull
            @Override
            public Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mybooks, parent, false);
                Adapter holder = new Adapter(view);
                return holder;
            }
        };

        mRecyclerView.setAdapter(adapter);
        adapter.startListening();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu,menu);
        MenuItem item=menu.findItem(R.id.search);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processSearch(String s) {

        FirebaseRecyclerOptions<BookModel>options=
                new FirebaseRecyclerOptions.Builder<BookModel>()
                        .setQuery(databaseReference.orderByChild("bookName").startAt(s.toUpperCase(Locale.ENGLISH)).endAt(s+"\uf8ff"),BookModel.class).build();

        FirebaseRecyclerAdapter<BookModel, Adapter> adapter = new FirebaseRecyclerAdapter<BookModel, Adapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Adapter holder, int position, @NonNull BookModel model) {

//                progressBar.setVisibility(View.GONE);
                holder.bookTitle.setText(model.getBookName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(model.getBookUrl()), "application/pdf");
                        startActivity(Intent.createChooser(intent, "Choose an Application:"));
                    }
                });

            }

            @NonNull
            @Override
            public Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mybooks, parent, false);
                Adapter holder = new Adapter(view);
                return holder;
            }
        };

        mRecyclerView.setAdapter(adapter);
        adapter.startListening();

    }
}