package com.ts.songs.defaults;

import com.ts.songs.model.Song;

/*
 * タイトル：曲シャッフルエンジン
 * 説明    ：曲のリストを設定し、次に再生する曲の情報を取得し、次に発生する予定の曲を返する。
 *
 * 著作権  ：Copyright(c) 2020　ts
 * 会社名  ：ts
 *
 * 変更履歴：2020/6/6（土）
 *        ：新規作成 マヘーシュ
 *
 */
public interface ShuffleEngine {

	/**
	 *　シャッフル対象の曲(Song)の配列をインスタンスに設定する。
	 *　設定後、曲リストのシャッフル処理を発生する。
	 *　
	 */
	void setSongs(Song[] songs);
	
	/**
	 *　次に再生する曲(Song)を返する。
	 *　次に返す曲が更新されます。
	 *
	 *　@return 曲　nextSong(Song)
	 */
	Song getNextSong();
	
	/**
	 * 曲種を取得する
	 * @return 曲種　genre(Genres)
	 */
	Song[] peekQueue();
}
