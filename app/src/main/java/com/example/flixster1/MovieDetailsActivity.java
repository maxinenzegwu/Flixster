package com.example.flixster1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixster1.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    Movie movie;

    TextView tvTitle;
    TextView tvOverview;
    RatingBar rbVoteAverage;
    TextView tvPop;

    ImageView ivBackdropPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        rbVoteAverage = findViewById(R.id.rbVoteAverage);
        tvPop = findViewById(R.id.tvPop);

        ivBackdropPoster = findViewById(R.id.ivBackdropPoster);

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        tvTitle.setText(movie.getTitle());
        tvOverview.setText((movie.getOverview()));
        tvPop.setText(movie.getPopularity().toString());

        Glide.with(getApplicationContext()).load(movie.getBackdropPath()).into(ivBackdropPoster);

        float voteAverage = movie.getVote_average().floatValue();
        rbVoteAverage.setRating(voteAverage = voteAverage > 0? voteAverage/2.0f : voteAverage);
    }
}