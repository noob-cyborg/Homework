package com.example.homework.domain

import com.example.homework.R
import com.example.homework.R.drawable
import com.example.homework.data.models.Actor
import com.example.homework.data.models.Movie

class MoviesDataSource {

    val movies: List<Movie>

    init {
        movies = arrayListOf(
            Movie(
                posterId = R.drawable.orig_avengers,
                smallPosterId = R.drawable.prev_avengers,
                movieTitle = "Avengers: End Game",
                tags = arrayListOf("Action, Adventure, Fantasy"),
                pg = 13,
                rating = 4.0f,
                reviews = 125,
                storyline = "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
                movieDuration = 137,
                actors = arrayListOf(
                    Actor(drawable.movie_actor_pic_1, fullName = "Robert Downey Jr."),
                    Actor(R.drawable.movie_actor_pic_2, fullName = "Chris Hemsworth"),
                    Actor(R.drawable.movie_actor_pic_3, fullName = "Mark Ruffalo"),
                    Actor(R.drawable.movie_actor_pic_4, fullName = "Chris Evans"),
                    Actor(R.drawable.movie_actor_pic_1, fullName = "Robert Downey Jr."),
                    Actor(R.drawable.movie_actor_pic_2, fullName = "Chris Hemsworth"),
                    Actor(R.drawable.movie_actor_pic_3, fullName = "Mark Ruffalo")
                )
            ),
            Movie(
                posterId =R.drawable.orig_avengers,
                smallPosterId = R.drawable.prev_black_widow,
                movieTitle = "Black Widow",
                tags = arrayListOf("Action, Adventure, Sci-Fi"),
                pg = 13,
                rating = 4.0f,
                reviews = 38,
                storyline = "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.",
                movieDuration = 102,
            ),
            Movie(
                posterId = R.drawable.orig_avengers,
                smallPosterId = R.drawable.prev_tenet,
                movieTitle = "Tenet",
                tags = arrayListOf("Action, Sci-Fi, Thriller"),
                pg = 16,
                rating = 5.0f,
                reviews = 98,
                storyline = "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                movieDuration = 97,
            ),
            Movie(
                posterId = R.drawable.orig_avengers,
                smallPosterId = R.drawable.prev_wonder_woman_1984,
                movieTitle = "Wonder Woman 1984",
                tags = arrayListOf("Action, Adventure, Fantasy"),
                pg = 13,
                rating = 5.0f,
                reviews = 74,
                storyline = "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                movieDuration = 120,
            ),
            Movie(
                posterId = R.drawable.orig_avengers,
                smallPosterId = R.drawable.prev_iron_man,
                movieTitle = "Iron Man",
                tags = arrayListOf("Action, Adventure, Fantasy"),
                pg = 13,
                rating = 4.0f,
                reviews = 70,
                storyline = "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
                movieDuration = 126,
            ),
            Movie(
                posterId = R.drawable.orig_avengers,
                smallPosterId = R.drawable.prev_knives_out,
                movieTitle = "Knives Out",
                tags = arrayListOf("Mystery, Comedy, Drama, Crime"),
                pg = 13,
                rating = 4.0f,
                reviews = 9,
                storyline = "When renowned crime novelist Harlan Thrombey is found dead at his estate just after his 85th birthday, the inquisitive and debonair Detective Benoit Blanc is mysteriously enlisted to investigate. From Harlan's dysfunctional family to his devoted staff, Blanc sifts through a web of red herrings and self-serving lies to uncover the truth behind Harlan's untimely death.",
                movieDuration = 131,
            ),

        )
    }
}