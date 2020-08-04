/*
*　タイトル 	： テスト結果
*　説明	    ： テスト結果の処理
*
*　著作権   	： Copyright(c) 2014
*　会社名   	： XXX
*
*　変更履歴 	： 
*			(V1.0) 2014年2月3日(月) 新規作成 
*
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
*  ExamSummaryクラス
*  @author Magesh
*  @creation 2014/2/3
*  @version 1.0
*
*/
public class ExamSummary {

    //科目定義
	enum Subject {
		MATH, SCIENCE, ENGLISH
	}

    //学籍番号,科目,得点の記録
	private Map<String, Map<Subject, Integer>> mpExamResults = new HashMap<String, Map<Subject, Integer>>();

	/*
	*　学籍番号,科目,得点を登録する
	* @param 学籍番号,科目,得点
	* @return なし
	*/
	void register(String registerNo, Subject subject, int point) {
		
		//科目,得点を取得
		Map<Subject, Integer> mpResults = mpExamResults.get(registerNo);

		//nullの場合、新規インスタンスを作成
		if (mpResults == null) {	
			mpResults = new HashMap<Subject, Integer>();
		}
		
		//科目,得点を設定
		mpResults.put(subject, point);
		//定義にデータ(学籍番号,科目,得点)を設定
		mpExamResults.put(registerNo, mpResults);
		
	}

	/*
	* 引数で指定された学籍番号・科目の得点を返す
	* @param 学籍番号,科目
	* @return 得点
	*/
	int getScore(String registerNo, Subject subject) {
        //得点を返す
		return mpExamResults.get(registerNo).get(subject);
	}

	/*
	* 引数で指定された科目の最高得点の学籍番号を返す
	* @param 科目
	* @return 学籍番号のリスト
	*/
	List<String> getTopScoreIdsBySubject(Subject subject) {
	
		//学籍番号
        String sRegisterNo = null;
		//最高得点
        int iHighScore = 0;
		//最高得点を取得
        for (Entry<String, Map<Subject, Integer>> entResult : mpExamResults.entrySet()) {
			//得点
			Integer iScore = entResult.getValue().get(subject);
			//現在の得点より最高得点が低い場合、
			if (iHighScore < iScore) {
				//最高得点
                iHighScore = iScore;
				//学籍番号
                sRegisterNo = entResult.getKey();
			}
		}
        
        //学籍番号のリスト
		List<String> lstResult = new ArrayList<String>();
		lstResult.add(sRegisterNo);
		//返す
		return lstResult;
	}

    /*
    * 全科目の平均得点の高い順に学籍番号を返す
    * @return 学籍番号のリスト
    */
	List<String> getIdsByAverage() {
        
        //平均得点
		Map<String, Double> mpAvgResult = new HashMap<String, Double>();
        
        //登録された値から平均得点を計算します。
		for (Entry<String, Map<Subject, Integer>> entResults : mpExamResults.entrySet()) {
			//得点集計
            int iResultSum = 0;
			//カウント
            int iCount = 0;
			//平均得点を設定します。
            for (Entry<Subject, Integer> entSubject : entResults.getValue().entrySet()) {
				//
                iResultSum += entSubject.getValue();
				//
                iCount++;
			}
            mpAvgResult.put(entResults.getKey(), new Double(iResultSum) / new Double(iCount));
		}

        //並び順
		List<Entry<String, Double>> lstAvgResult = new ArrayList<Entry<String, Double>>(mpAvgResult.entrySet());
		Collections.sort(lstAvgResult, new Comparator<Entry<String, Double>>() {
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				Entry<String, Double> e1 = o1;
				Entry<String, Double> e2 = o2;
				return ((Double) e2.getValue()).compareTo((Double) e1.getValue());
			}
		});

        //返すリストを作成
		List<String> lstResult = new ArrayList<String>();
		for (Entry<String, Double> entResult : lstAvgResult) {
			lstResult.add(entResult.getKey());
		}
        //返す
		return lstResult;
	}

    /*
    * メイン関数
    * @param 文字列配列
    */
    public static void main(String args[])
    {
        //インスタンスを作成
        ExamSummary es = new ExamSummary();
		//データを設定
        es.register ("00kc001",Subject.MATH , 85);
        es.register ("00kc001",Subject.SCIENCE , 75);
        es.register ("00kc001",Subject.ENGLISH , 65);
        es.register ("00kc002",Subject.MATH , 60);
        es.register ("00kc002",Subject.SCIENCE , 80);
        es.register ("00kc002",Subject.ENGLISH , 70);
        es.register ("00kc003",Subject.MATH , 90);
        es.register ("00kc003",Subject.SCIENCE , 55);
        es.register ("00kc003",Subject.ENGLISH , 65);
        //得点を取得
		int score = es.getScore("00kc002",Subject.MATH);
        System.out.println(score);
		//最高得点を取得
        List<String> topScoreIds = es.getTopScoreIdsBySubject(Subject.ENGLISH);
        System.out.println(topScoreIds);
		//平均得点を取得
		List<String> ids = es.getIdsByAverage();
        System.out.println(ids);
    }

}