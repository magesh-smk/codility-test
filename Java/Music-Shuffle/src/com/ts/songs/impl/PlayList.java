package com.ts.songs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

import com.ts.songs.defaults.ShuffleEngine;
import com.ts.songs.model.Song;

/*
 * タイトル：プレイリストクラス
 * 説明    ：内部で楽曲を表すクラスSongのコレクションを保持し、
 * 　　　　　　　呼ばれるたびにシャッフルされた曲順で曲を返す。
 *
 * 著作権  ：Copyright(c) 2020　ts
 * 会社名  ：ts
 *
 * 変更履歴：2020/6/6（土）
 *        ：新規作成 マヘーシュ
 *
 */
public class PlayList implements ShuffleEngine {

	// 曲リスト
	private List<Song> songs = new ArrayList<Song>();
	// シャッフル曲リスト
	private List<Song> shuffleList = new ArrayList<Song>();
	// 曲数（ユニック曲）
	private int count;
	// 再生インデックス
	private int currentPlayIndex = 0;
	// PEEK上限数
	private final Integer PEEKMAX = 5;
	
	
	/**
	 *　シャッフル対象の曲(Song)の配列をインスタンスに設定する。
	 *　設定後、曲リストのシャッフル処理を発生する。
	 *　
	 */
	@Override
	public void setSongs(Song[] songs) {
		// 曲リストを設定
		this.songs =  Arrays.asList(songs);
		// ユニックな曲リストを作成
		this.songs = this.songs.stream().distinct().collect(Collectors.toList());
		// シャッフル曲リストを作成
		this.shuffleList = new ArrayList<Song>(this.songs); 
		// シャッフル曲リストの数
		this.count = this.songs.size();
		//　再生のインデックス
		this.currentPlayIndex = 1;
		
		// 設定された曲リストのシャッフルを行う
		Shuffle(this.shuffleList);
	}

	
	/**
	 *　次に再生する曲(Song)を返する。
	 *　次に返す曲が更新されます。
	 *
	 *　@return 曲　nextSong(Song)
	 */
	@Override
	public Song getNextSong() {

		// シャッフル曲リストが空の場合、空の曲情報を返す
		if(this.shuffleList.size() <= 0) {
			return new Song();
		}

		// 再生のインデックスを更新
		this.currentPlayIndex += 1;
		
		// 次に再生する曲(Song)を取得
		Song retSong = this.shuffleList.get(this.currentPlayIndex-1);
		
		// 次に再生する曲インデックスが配列数と超える場合、再びシャッフル処理を発生し、再生のインデックスを更新する
		if(this.currentPlayIndex >= this.count) {
			//　シャッフル曲リストからのシャッフルを行う
			Shuffle(this.shuffleList);
			// 再生のインデックスを更新する
			this.currentPlayIndex = 0;
		}
		
		// 次に再生曲を返す
		return retSong;
		
	}

	/**
	 * 曲種を取得する
	 * @return 曲種　genre(Genres)
	 */
	@Override
	public Song[] peekQueue() {
		
		// シャッフル曲リストが空の場合、空の曲情報を返す
		if(this.shuffleList.size() <= 0) {
			return new ArrayList<Song>().toArray(new Song[0]);
		}
		
		// PEEKMAXの数を上限として,次に再生する予定の曲を先読みして配列として返す。
		return this.shuffleList.subList(this.currentPlayIndex, (this.currentPlayIndex + PEEKMAX < this.shuffleList.size()) ? this.currentPlayIndex + PEEKMAX : this.shuffleList.size()).toArray(new Song[0]);
		
	}
	
	/**
	 * 曲リストの要素をシャッフルする
	 * シャッフル曲リストからランダムで配列をスワップする。
	 * さらに、シャッフルされた一覧に次の曲は同じくアルバム名、アーティスト、曲種が存在する場合、なるべく繰り返すないように条件を設定する
	 * @param 曲リスト songs(List)
	 */
	public void Shuffle(List<Song> list) {
		
		// ランダムインスタンスを作成
		Random rand = new Random();
		rand.nextInt();
		
		// 曲リストからランダムにシャッフルを行う
		for (int i = list.size() - 1; i > 0; i--) {
		
			//　ランダムのインデックス番号を取得
			int j = rand.nextInt(this.count-1);
			// ランダムインデックスで曲リストをスワップする
			Collections.swap(list, i, j);
			
		}

		
		// 望ましいシャッフルの処理を発生
		// リスナが楽しく聞くために、再生の曲はアルバム名、アーティスト、曲種がなるべく同じく発生しないする。
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				// 再生の曲はアルバム名、アーティスト、曲種が一致する場合、更なりシャッフルを行う
				if (list.get(i).getArtist() == list.get(j).getArtist()
						|| list.get(i).getAlbum() == list.get(j).getAlbum()
						|| list.get(i).getGenre() == list.get(j).getGenre()) {
					if (j < list.size() - 2) {
						Collections.swap(list, j, j + 1);
					}
				}
			}
		}

		// リスナ希望リストを設定する
		this.shuffleList = Arrays.asList(list.toArray(new Song[0]));

	}


}
