package com.douzone.container.videosystem;

import java.util.List;

public class BlankDisc implements DigitalVideoDisc {
	private String title;
	private String studio;
	private List<String> actors;

	public BlankDisc() {

	}

	public BlankDisc(String title, String studio) {
		this.title = title;
		this.studio = studio;
	}

	public BlankDisc(String title, String studio, List<String> actors) {
		this.title = title;
		this.studio = studio;
		this.actors = actors;
	}

	@Override
	public String play() {
		return "Playing Movie " + studio + "'s " + title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "BlankDisc [title=" + title + ", studio=" + studio + ", actors=" + actors + "]";
	}

}
