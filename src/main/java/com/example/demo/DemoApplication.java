package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		MusicPlayer ms = new MusicPlayer();
		ms.addSong("A", "Rohan");
		ms.addSong("B", "Rohan");
		ms.addSong("C", "Harshit");

		ms.playSong("A", LocalDate.of(2023, 12, 25));
		ms.playSong("B", LocalDate.of(2023, 12, 25));
		ms.playSong("B", LocalDate.of(2023, 12, 25));
		ms.playSong("C", LocalDate.of(2023, 12, 25));

		System.out.println(ms.topSongByDate(LocalDate.of(2023, 12, 25)));
		System.out.println(ms.topSongByArtist("Rohan"));
		System.out.println(ms.topSong());

		CsvReader playlist = new CsvReader();
		TsvReader playlist1 = new TsvReader();
		playlist.read();
		playlist1.read();
	}

}
