package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    Movie first = new Movie();
    Movie second = new Movie();
    Movie third = new Movie();
    Movie fourth = new Movie();
    Movie fifth = new Movie();
    Movie sixth = new Movie();
    Movie seventh = new Movie();
    Movie eighth = new Movie();
    Movie ninth = new Movie();
    Movie tenth = new Movie();
    Movie eleventh = new Movie();

    Manager movieManager = new Manager();     //создание пустого объекта

    @Test
    void shouldAddedToEmptyList() {     //добавь новый элемент в пустой список
        movieManager.addNewMovie(first);        //тестируемое действие - сохрани первый элемент

        Movie[] expected = {first};     //expected - ожидаемый результат, покажи запомненный элемент
        Movie[] actual = movieManager.getMovies();        //дай фильм, который ты запомнил
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddIfAlreadyContains() {     //добавь новый элемент к уже имеющимся
        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);

        Movie[] expected = {first, second};
        Movie[] actual = movieManager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllMovies() {        //покажи все фильмы
        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Movie[] actual = movieManager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrder() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10)
        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetEmptyList() {     //дай мне пустой список
        Movie[] expected = {};
        Movie[] actual = movieManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLast5MoviesInReverseOrder() {     //найди последние 5 фильмов в обратном порядке
        Manager movieManager = new Manager(5);

        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfQuantityIs0() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если в конструктор передается 0
        Manager movieManager = new Manager(0);

        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfQuantityIsLessThen0() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если в конструктор передается меньше 0
        Manager movieManager = new Manager(-1);

        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfAdd5() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если добавлены 5
        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);

        Movie[] expected = {fifth, fourth, third, second, first};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }
}
