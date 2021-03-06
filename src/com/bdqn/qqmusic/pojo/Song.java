package com.bdqn.qqmusic.pojo;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * Song entity. @author MyEclipse Persistence Tools
 */

public class Song implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Artist artist;
	private Record record;
	private String sname;
	private String scompose;
	private Time sduration;
	private String sarrangement;
	private Set songLists = new HashSet(0);

	// Constructors

	/** default constructor */
	public Song() {
	}

	/** minimal constructor */
	public Song(Artist artist, Record record, String sname) {
		this.artist = artist;
		this.record = record;
		this.sname = sname;
	}

	/** full constructor */
	public Song(Artist artist, Record record, String sname, String scompose,
			Time sduration, String sarrangement, Set songLists) {
		this.artist = artist;
		this.record = record;
		this.sname = sname;
		this.scompose = scompose;
		this.sduration = sduration;
		this.sarrangement = sarrangement;
		this.songLists = songLists;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Artist getArtist() {
		return this.artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Record getRecord() {
		return this.record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getScompose() {
		return this.scompose;
	}

	public void setScompose(String scompose) {
		this.scompose = scompose;
	}

	public Time getSduration() {
		return this.sduration;
	}

	public void setSduration(Time sduration) {
		this.sduration = sduration;
	}

	public String getSarrangement() {
		return this.sarrangement;
	}

	public void setSarrangement(String sarrangement) {
		this.sarrangement = sarrangement;
	}

	public Set getSongLists() {
		return this.songLists;
	}

	public void setSongLists(Set songLists) {
		this.songLists = songLists;
	}

}