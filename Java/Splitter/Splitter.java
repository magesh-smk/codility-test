/*
*　タイトル	： スプリッター
*　説明		： 文字列の分割処理
*
*　著作権	： Copyright(c) 2014
*　会社名	： XXX
*
*　変更履歴	： 
*	　　　	(V1.0) 2014年2月3日(月) 新規作成 
*
*/
import java.util.ArrayList;
import java.util.List;

/*
*  Splitterクラス
*  @author Magesh
*  @creation 2014/2/3
*  @version 1.0
*
*/
public final class Splitter {

	//区切り文字
    public String delimiter;
	//トリムフラグ
    public boolean trimResults = false;
	//空の文字列フラグ
	public boolean omitEmptyStrings = false;

	/*
	* 区切り文字を設定
	* @param 区切り文字
	* @return Splitter
	*/
	public static Splitter on(char delimiter) {
		return Splitter.on(String.valueOf(delimiter));
	}

	/*
	* 区切り文字を設定
	* @param 区切り文字列
	* @return Splitter
	*/
	public static Splitter on(String delimiter) {
		Splitter s = new Splitter();
		s.delimiter = delimiter;
		return s;
	}

	/*
	* 分割処理
	* @param 値
	* @return Splitter
	*/	
	public Iterable<String> split(CharSequence data) {
		return split(data.toString());
	}

	/*
	* 分割処理
	* @param 値
	* @return Splitter
	*/
	public Iterable<String> split(String data) {
		String[] strs = data.split(delimiter);
		//分割リスト
		List<String> result = new ArrayList<String>();
		for (String s : strs) {
			if (trimResults) {
				s = s.trim();
			}
			if (omitEmptyStrings) {
				if (s.isEmpty()) {
					continue;
				}
			}
			result.add(s);
		}
		//返す
		return result;
	}

	/*
	* トリム処理を有効
	* @return Splitter
	*/
	public Splitter trimResults() {
		trimResults = true;
		return this;
	}

	/*
	* 空の文字列処理を有効
	* @return Splitter
	*/
	public Splitter omitEmptyStrings() {
		omitEmptyStrings = true;
		return this;
	}

}