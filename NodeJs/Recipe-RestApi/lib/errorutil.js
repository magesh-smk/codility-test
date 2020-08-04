/**
 * Error List
 */
var ERR =
{
    ja :{
        /** Common errors */
        ERR000000 : '正常に処理しました。',
        ERRPRC001 : '処理中にエラー発生しました。',
        ERRUFL001 : 'ファイル処理中にエラー発生しました。',
        /** Database related errors */
        ERRDTB001 : 'データベースの接続中にエラー発生しました。',
        ERRDTB002 : 'データベース処理中にエラー発生しました。',
        /** User related errors */
        ERRUSR001 : "ユーザーが存在しません。",
        ERRUSR002 : 'アクティベーション又はメールアドレスの確認処理を行っていません。',
        ERRUSR003 : 'ユーザーのステータスは無効です',
        ERRUSR004 : 'ユーザーのステータスは削除中です。管理者まで連絡ください。',
        ERRUSR005 : 'メールID又はパスワードの誤りです。',
        ERRUSR006 : "登録処理に失敗しました。ユーザーが存在しています。",
        ERRUSR007 : "アクティベーション情報が存在しません。",
        ERRUSR008 : "アクティベーションが正常に完了しました。",
        ERRLGN001 : "セッションがタイムアウトしました",
        /** Identity related errors  */
        /** Python AI errors */
        ERRAIS001 : "サブシステムの接続が失敗しました。",

    },
    en : 
    {
        /** Common errors */
        ERR000000 : 'Successfully completed.',
        ERRPRC001 : 'Error occurred in process.',
        ERRUFL001 : 'Error occurred in file process.',
        /** Database related errors */
        ERRDTB001 : 'Database connection error.',
        ERRDTB002 : 'Error occurred while processing database.',
        /** User related errors */
        ERRUSR001 : "User doesn't exists.",
        ERRUSR002 : 'Email-id confirmation is not completed.',
        ERRUSR003 : 'User status is inactive.',
        ERRUSR004 : 'User is disabled. Please contact system adminitrator.',
        ERRUSR005 : 'Mail-Id or Password is mismatch.',
        ERRUSR006 : "User registration is failed. Already the user exists.",
        ERRUSR007 : "Activation Information doesn't exists.",
        ERRUSR008 : "Activation completed successfully.",
        ERRLGN001 : "Session is expired.",
         /** Identity related errors  */
        /** Python AI errors */
        ERRAIS001 : "Sub-System connectivity error occurred.",
    }
}

/**
 * Attach to the module
 * @param {*} mode 
 */
module.exports = function(mode) {
	return ERR[mode] || ERR.ja;
}