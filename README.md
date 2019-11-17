# gemini-kotlin

### 概要

下記記事を元にSpringBoot+Vue.js+ElementUI+Firebaseにて
マスタ管理アプリを作成しました。

@shunp  
[SpringBoot+Vue.js+ElementUI+Firebaseでマスタ管理アプリ入門](https://qiita.com/shunp/items/abea7fa01e7a664c85da)
 

自分なりに少し手を加えてみました。  
java部分をKotlinへ変更し、下記記事を参考に
SpringBootのプロジェクトにVue.jsのプロジェクトを組み込みました。

@iwanagat85  
[SpringBoot+Vueなアプリケーションを構築する](https://qiita.com/iwanagat85/items/eeb0a0e19cb35d160429)


### ソースの取得
```shell script
git clone https://github.com/t-nakata/gemini-kotlin.git
```

### Firebaseの認証情報設定

`web/src/main.js`
15行目からのFirebase設定値を自分のプロジェクトの設定に変更

```ecmascript 6
const config = {
  apiKey: "************************",
  authDomain: "************************.firebaseapp.com",
  databaseURL: "************************.firebaseio.com",
  projectId: "************************",
  storageBucket: "************************.appspot.com",
  messagingSenderId: "************************"
};
```

ビルド＆実行プロジュエクトのRootディレクトリで下記コマンドを実行

```
./gradlew bootRun
```

ブラウザで`http://localhost:8080`へアクセス`Sign in画面`が表示されれば成功です。