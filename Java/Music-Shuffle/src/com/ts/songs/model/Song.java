package com.ts.songs.model;

import com.ts.songs.util.Genres;

/*
 * タイトル：曲モデルクラス
 * 説明    ：曲の情報を持ちし、情報を設定および取得すること可能です。
 *
 * 著作権  ：Copyright(c) 2020　ts
 * 会社名  ：ts
 *
 * 変更履歴：2020/6/6（土）
 *        ：新規作成 マヘーシュ
 *
 */
public class Song {
	
	// タイトル
	private String title="";
	// 曲のアーティスト
	private String artist="";
	// アルバム
	private String album="";
	// 音楽のジャンル
	private Genres  genre = Genres.NONE;
	// 曲の長さ
	private int length = 0;
	// 視聴率
	private double rating= 0;
	
	/**
	 * コンストラクタです。（パラメータなし）
	 * 
	 */
	public Song() {
		
	}
	
	/**
	 * コンストラクタです。（パラメータあり）
	 * 
	 */
	public Song(String Title, String Artist, String Album, Genres Genre, int Length, double Rating) {
		// タイトル
		this.title = Title;
		// 曲のアーティスト
		this.artist = Artist;
		// アルバム
		this.album = Album;
		// 音楽のジャンル
		this.genre = Genre;
		// 曲の長さ（秒）
		this.length = Length;
		// 視聴率
		this.rating = Rating;
	}
	
	/**
	 * 曲のタイトルを取得する
	 * @return タイトル　title(String)
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 曲のタイトルを設定する
	 * @param タイトル　title(String)
	 * @return なし
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 曲のアーティストを取得する
	 * @return アーティスト　artist(String)
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * 曲のアーティストを設定する
	 * @param アーティスト　artist(String)
	 * @return なし
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/**
	 * 曲のアルバム名を取得する
	 * @return アルバム名　album(String)
	 */
	public String getAlbum() {
		return album;
	}
	
	/**
	 * 曲のアルバム名を設定する
	 * @param アルバム名　album(String)
	 * @return なし
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	
	/**
	 * 曲種を取得する
	 * @return 曲種　genre(Genres)
	 */
	public Genres getGenre() {
		return genre;
	}
	
	/**
	 * 曲種を設定する
	 * @param 曲種　genre(Genres)
	 * @return なし
	 */
	public void setGenre(Genres genre) {
		this.genre = genre;
	}
	
	/**
	 * 曲の長さ（期間）を取得する
	 * @return 長さ（秒単位）　length(int)
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * 曲の長さ（期間）を設定する
	 * @param 長さ　length(int)
	 * @return なし
	 */
	public void setLength(int hour, int minutes, int seconds) {
		this.length = (60*60*hour) + (60*minutes) + (seconds) ;
	}
	
	/**
	 * 曲の視聴率を取得する
	 * @return 視聴率　rating(double)
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * 曲の視聴率を設定する
	 * @param 視聴率　rating(double)
	 * @return なし
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/**
     * このクラスのインスタンスと引数で渡されたオブジェクトが
     * 同値であるばあいtrueを返します。
     * 引数で渡されたオブジェクトがSongクラスのインスタンスであり、
     * タイトル、アルバム名、アーティスト、長さの値が等しい場合、同値であるとみなされます。
     *
     * @return 引数で渡されたオブジェクトがSongクラスのインスタンスであり、タイトル、アルバム名、アーティスト、長さが等しい場合true（boolean）。
     */
    @Override
    public boolean equals(Object obj) {      
    	if (obj instanceof Song) {
            return ((Song) obj).title == title && ((Song) obj).album == album && ((Song) obj).artist == artist && ((Song) obj).length == length ;
        }
        return false;
    }
    
    /**
     * ハッシュコードを返する
     *
     * @return このクラスのインスタンスのハッシュ値 hashcode(int)
     */
    @Override
    public int hashCode() {
        return (this.title+this.album+this.artist+this.length).toString().hashCode();
    }
    
    /**
     * このメソッドは、Songオブジェクトの値を表す
     * 指定されたオブジェクト値とその要素を表す文字列を返する
     * 
     * @return Songオブジェクトの値（タイトル、アルバム名、アーティスト） tostring(String)
     */
    @Override
    public String toString() {
    	return ("タイトル：" + this.title + " アルバム名：" + this.album + " アーティスト：" + this.artist);
    }
    
}

