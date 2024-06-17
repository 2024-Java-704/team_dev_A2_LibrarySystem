-- カテゴリーテーブルデータ
INSERT INTO categories(categories_num, categories_name) VALUES(00, '総記');
INSERT INTO categories(categories_num, categories_name) VALUES(10, '哲学');
INSERT INTO categories(categories_num, categories_name) VALUES(20, '歴史');
INSERT INTO categories(categories_num, categories_name) VALUES(30, '社会科学');
INSERT INTO categories(categories_num, categories_name) VALUES(40, '自然科学');
INSERT INTO categories(categories_num, categories_name) VALUES(50, '技術・工学');
INSERT INTO categories(categories_num, categories_name) VALUES(60, '産業');
INSERT INTO categories(categories_num, categories_name) VALUES(70, '芸術・美術');
INSERT INTO categories(categories_num, categories_name) VALUES(80, '言語');
INSERT INTO categories(categories_num, categories_name) VALUES(90, '文学');
INSERT INTO categories(categories_num, categories_name) VALUES(100, '漫画');

-- 本テーブルデータ
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(1, 'FACTFULNESS', 'ふぁくとふるねす' ,'ハンス・ロスリング','日経BP', '2019/01/11','2024/01/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '眠れなくなるほど面白い 図解 宇宙の話', 'ねむれなくなるほどおもしろい ずかい うちゅうのはなし' ,'渡部潤一','日本文芸社', '2018/03/30','2024/01/03',2,1, 200);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '君のお金は誰のため', 'きみのおかねはだれのため' ,'田内学','東洋経済新報社', '2023/10/18','2024/01/05',3,1, 150);

INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '哲学と宗教全史', 'てつがくとしゅうきょうぜんし' ,'出口治明','ダイヤモンド社', '2019/08/08','2020/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '世界が面白くなる！身の回りの哲学', 'せかいがおもしろくなる！みのまわりのてつがく' ,'小川仁志','あさ出版', '2022/11/14','2023/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '14歳からの哲学 考えるための教科書', '14さいからのてつがく かんがえるためのきょうかしょ' ,'池田晶子','トランスビュー', '2003/03/20','2020/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '世界のエリートが学んでいる教養としての哲学', 'せかいのえりーとがまなんでいるきょうようとしてのてつがく' ,'小川仁志','PHP研究所', '2018/06/01','2020/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '哲学用語図鑑', 'てつがくようごずかん' ,'田中正人','プレジデント社', '2015/02/26','2020/04/01',1,1, 200);

INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(3, '眠れなくなるほど面白い 図解 孫氏の兵法', 'ねむれなくなるほどおもしろい ずかい そんしのへいほう' ,'島崎晋','日本文芸社', '2019/02/22','2020/04/01',1,1, 330);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3, '眠れなくなるほど面白い 図解 論語', 'ねむれなくなるほどおもしろい ずかい ろんご' ,'山口謡司','日本文芸社', '2019/02/22','2020/04/01',1,2, 330,'/img/book10.jpg');
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(3, '眠れなくなるほど面白い 図解 神道', 'ねむれなくなるほどおもしろい ずかい しんどう' ,'渋谷申博','日本文芸社', '2020/04/22','2020/07/01',1,1, 330);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(3, '眠れなくなるほど面白い 図解 ギリシャ神話', 'ねむれなくなるほどおもしろい ずかい ぎりしゃしんわ' ,'島崎晋','日本文芸社', '2020/08/19','2021/04/01',1,1, 330);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(3, '眠れなくなるほど面白い 図解 仏教', 'ねむれなくなるほどおもしろい ずかい ぶっきょう' ,'渋谷申博','日本文芸社', '2019/07/24','2020/04/01',1,1, 330);


INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(4, '科学の社会史', 'かがくのしゃかいし' ,'古川安','筑摩書房', '2018/10/11','2020/06/01',1,1, 120);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(4, '社会科学の哲学入門', 'しゃかいかがくのてつがくにゅうもん' ,'吉田敬','勁草書房', '2021/08/27','2022/04/01',1,1, 230);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(4, '社会科学の考え方―認識論、リサーチ・デザイン、手法', 'しゃかいかがくのかんがえかた-にんしきろん、りさーちでざいん、しゅほう' ,'野村康','名古屋大学出版会', '2017/05/27','2020/04/01',1,1, 140);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(4, '社会科学のための統計学入門 実例からていねいに学ぶ', 'しゃかいかがくのためのとうけいがくにゅうもん じつれいからていねいにまなぶ' ,'毛塚和宏','講談社', '2022/06/23','2023/04/01',1,1, 120);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(4, '社会科学のためのデータ分析入門', 'しゃかいかがくのためのでーたぶんせきにゅうもん' ,'今井耕介','岩波書店', '2018/03/13','2020/04/01',1,1, 180);


INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(5, '科学の名著50冊が1冊でざっと学べる', 'かがくのめいちょ50さつが1さつでざっとまなべる' ,'西村能一','角川', '2020/09/26','2021/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(5, '巨大ブラックホールの謎 宇宙最大の「時空の穴」に迫る', 'きょだいぶらっくほーるのなぞ うちゅうさいだいの「じくうのあな」にせまる' ,'本間希樹','講談社', '2017/04/20','2020/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(5, '元JAXA研究員も驚いた！ヤバい宇宙図鑑', 'もとJAXAけんきゅういんもおどろいた！やばいうちゅうずかん' ,'谷岡憲隆','青春出版社', '2019/04/23','2020/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(5, '眠れなくなるほど面白い 図解 宇宙の話', 'ねむれなくなるほどおもしろい ずかい うちゅうのはなし' ,'渡部潤一','日本文芸社', '2018/03/17','2020/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(5, '物理学者のすごい思考法', 'ぶつりがくしゃのすごいしこうほう' ,'橋本幸士','集英社インターナショナル', '2021/02/05','2022/04/01',1,1, 100);

INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(6, '生成AIで世界はこう変わる', 'せいせAIでせかいはこうかわる' ,'今井翔太','SBクリエイティブ', '2024/01/07','2024/03/05',1,1, 280);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(6, '深層学習教科書 ディープラーニング G検定 公式テキスト', 'しんそうがくしゅうきょうかしょ でぃーぷらーにんぐ Gけんてい こうしきてきすと' ,'巣鴨悠輔','翔泳社', '2024/05/27','2024/06/01',1,1, 140);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(6, 'ホワイトハッカー入門', 'ほわいとはっかーにゅうもん' ,'阿部ひろき','インプレス', '2024/04/18','2024/06/01',1,1, 210);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(6, 'AWS認定資格試験テキスト AWS認定ソリューションアーキテクト - アソシエイト', 'AWSにんていしかくしけんてきすと AWSにんていそりゅーしょんあーきてくと -あそしえいと' ,'佐々木拓郎','SBクリエイティブ', '2023/09/28','2024/06/01',1,1, 165);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(6, 'ゼロから稼げるChatGPT入門', 'ぜろからかせげるChatGPTにゅうもん' ,'加納敏彦','きずな出版', '2024/03/07','2024/06/01',1,1, 210);


INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(7, '書いてはいけない-日本経済堕落の真相', 'かいてはいけない-にほんけいざいだらくのしんそう' ,'森永卓郎','フォレスト出版', '2024/03/09','2024/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(7, 'さあ、才能に目覚めよう', 'さあ、さいのうにめざめよう' ,'ジム・クリフトン','日経BP', '2023/06/15','2024/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(7, 'サイゼリア元社長が教える 年間客数2億人の経営術', 'さいぜりあもとしゃちょうがおしえる ねんかんきゃくすう2おくにんのけいえいじゅつ' ,'堀杢一成','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(7, 'ほったらかし投資術', 'ほったらかしとうしじゅつ' ,'山崎元','朝日新聞出版', '2022/03/11','2024/04/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(7, '図解・最新 難しいことはわかりませんが、お金の増やし方を教えてください', 'ずかい・さいしん むずかしいことはわかりませんが、おかねのふやしかたをおしえてください' ,'山崎元','文響社', '2017/11/29','2020/04/01',1,1, 100);


INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(8, '世界でいちばん素敵な西洋美術の教科書', 'せかいでいちばんすてきなせいようびじゅｙつのきょうかしょ' ,'永井龍之介','三才ブックス', '2018/10/04','2019/07/30',1,1, 138);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(8, '東京藝大で教わる西洋美術の見かた', 'とうきょうげいだいでおそわるせいようびじゅつのみかた' ,'佐藤直樹','世界文化社', '2021/01/27','2021/07/30',1,1, 380);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(8, '大学4年間の西洋美術史が10時間でざっと学べる', 'だいがく4ねんかんのせいようびじゅつしが10じかんでざっとまなべる' ,'池上英洋','世界文化社', '2020/07/16','2021/07/30',1,1, 125);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(8, 'いちばん親切な西洋美術史', 'いちばんしんせつなせいようびじゅつし' ,'池上英洋','新星出版社', '2016/07/15','2021/07/30',1,1, 80);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(8, '「自分だけの答え」が見つかる13歳からのアート思考', '「じぶんだけのこたえ」がみつかる13さいからのあーとしこう' ,'末永幸歩','ダイヤモンド社', '2020/02/20','2021/07/30',1,1, 50);

INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(9, '「何回説明しても伝わらない」はなぜ起こるのか？認知科学が教えるコミュニケーションの本質と解決策', '「なんかいせつめいしてもつたわらない」はなぜおこるのか？にんちかがくがおしえるこみゅにけーしょんのほんしつとかいけつさく' ,'今井むつみ','日経BP', '2024/05/09','2024/06/01',1,1, 13);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(9, '漢検3級 過去問題集', 'かんけん3きゅう　かこもんだいしゅう' ,'','日本漢字能力検定協会', '2023/03/27','2023/08/30',1,1, 130);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(9, '世界の一流は「雑談」で何を話しているのか', 'せかいのいちりゅうは「ざつだん」でなにをはなしているのか' ,'ピョートル・フェリクス・グジバチ','クロスメディア・パブリッシング', '2023/03/31','2023/07/30',1,1, 220);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(9, 'TOEIC L&R TEST はじめから超特急 金のパッケージ', 'TOEIC L&R TEST はじめから ちょうとっきゅう きんのぱっけーじ' ,'TEX 加藤','朝日新聞出版社', '2024/01/19','2024/03/03',1,1, 520);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(9, 'はじめて受けるTOEIC L&Rテスト 全パート完全攻略', 'はじめてうけるTOEIC L&Rてすと ぜんぱーとかんぜんこうりゃく' ,'小石裕子','アルク', '2018/03/07','2021/07/30',1,1, 518);

INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(10, '東大発！1万人の子供が変わった ハマるおうち読書', 'とうだいはつ！1まんにんのこどもがかわった はまるおうちどくしょ' ,'笹沼颯太','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',1,1, 280);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(10, '世界で活躍する子の英語力の育て方', 'せかいでかつやくするこのえいごりょくのそだてかた' ,'船津徹','大和書房', '2019/06/20','2021/07/30',1,1, 235);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(10, '傲慢と善良', 'ごうまんとぜんりょう' ,'辻村深月','朝日新聞出版', '2022/09/07','2022/10/30',1,1, 320);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(10, 'コンビニ人間', 'こんびににんげん' ,'村田沙耶香','文藝春秋', '2018/09/04','2021/07/30',1,1,340);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10, 'アリス殺し', 'ありすごろし' ,'小林泰三','東京創元社', '2019/04/24','2021/07/30',1,1, 360,'/img/book48.jpg');
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(10, 'コンビニ人間', 'こんびににんげん' ,'村田沙耶香','文藝春秋', '2018/09/04','2021/07/30',2,1,340);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(10, '傲慢と善良', 'ごうまんとぜんりょう' ,'辻村深月','朝日新聞出版', '2022/09/07','2022/10/30',3,1, 320);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10, 'アリス殺し', 'ありすごろし' ,'小林泰三','東京創元社', '2019/04/24','2021/07/30',2,1, 3,'/img/book48.jpg');
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10, 'アリス殺し', 'ありすごろし' ,'小林泰三','東京創元社', '2019/04/24','2021/07/30',3,1, 3,'/img/book48.jpg');

--図書館テーブルデータ
INSERT INTO library(name,address,tel) VALUES('港区図書館','東京都港区','03-1111-2222');
INSERT INTO library(name,address,tel) VALUES('品川区図書館','東京都品川区','03-1111-3333');
INSERT INTO library(name,address,tel) VALUES('千代田区図書館','東京都千代田区','03-1111-4444');
--ステータステーブルデータ
INSERT INTO status(name) VALUES('予約中');
INSERT INTO status(name) VALUES('予約キャンセル');
INSERT INTO status(name) VALUES('貸出済み');
--状態テーブルデータ
INSERT INTO condition(name) VALUES('貸出可');
INSERT INTO condition(name) VALUES('貸出不可');
--利用者テーブルデータ
INSERT INTO users(name,email,address,tel,password,library_id) VALUES('田中太郎','tanaka@mail.com','東京都大田区','090-1111-5555','aaa',1);
INSERT INTO users(name,email,address,tel,password,library_id) VALUES('橋本一郎','hasimoto@mail.com','東京都港区','090-1111-6666','bbb',2);
INSERT INTO users(name,email,address,tel,password,library_id) VALUES('佐藤二郎','satou@mail.com','東京都文京区','090-1111-7777','ccc',3);
--図書館職員テーブルデータ
INSERT INTO library_staff(library_id,name,email,password) VALUES(1,'田中花子','tanaka@mail.com','ddd');
INSERT INTO library_staff(library_id,name,email,password) VALUES(2,'加藤三郎','katou@mail.com','eee');
INSERT INTO library_staff(library_id,name,email,password) VALUES(3,'斎藤四郎','saitou@mail.com','fff');
--図書館管理者テーブルデータ
INSERT INTO library_manager(name,email,password) VALUES('山田太郎','yamada@mail.com','ggg');
--貸出テーブルデータ
INSERT INTO lending(user_id,book_id,lend_date,limit_date,returned_date,reservation_id,staff_id) VALUES(1,1,'2024/05/03','2024/05/10','2024/05/07',1,1); --延滞なし・返却あり・図書館ID1
INSERT INTO lending(user_id,book_id,lend_date,limit_date,returned_date,staff_id) VALUES(1,49,'2024/05/03','2024/05/10','2024/05/07',2); --延滞なし・返却あり・図書館ID1
INSERT INTO lending(user_id,book_id,lend_date,limit_date,returned_date,staff_id) VALUES(1,50,'2024/05/03','2024/05/10','2024/05/07',3); --延滞なし・返却あり・図書館ID2
INSERT INTO lending(user_id,book_id,lend_date,limit_date,staff_id) VALUES(2,10,'2024/05/10','2024/05/17',1); --延滞あり・返却なし・図書館ID1
INSERT INTO lending(user_id,book_id,lend_date,limit_date,staff_id) VALUES(2,49,'2024/05/10','2024/05/17',2); --延滞あり・返却なし・図書館ID2
INSERT INTO lending(user_id,book_id,lend_date,limit_date,staff_id) VALUES(3,50,'2024/05/10','2024/05/17',3); --延滞あり・返却なし・図書館ID3
INSERT INTO lending(user_id,book_id,lend_date,limit_date,staff_id) VALUES(3,48,'2024/06/10','2024/06/17',1); --延滞なし・返却なし・図書館ID1
INSERT INTO lending(user_id,book_id,lend_date,limit_date,staff_id) VALUES(3,49,'2024/06/10','2024/06/17',2); --延滞なし・返却なし・図書館ID2
INSERT INTO lending(user_id,book_id,lend_date,limit_date,staff_id) VALUES(3,50,'2024/06/10','2024/06/17',3); --延滞なし・返却なし・図書館ID3
INSERT INTO lending(user_id,book_id,lend_date,limit_date,returned_date,staff_id) VALUES(2,48,'2024/05/10','2024/05/17','2024/05/20',1); --延滞あり・返却あり・図書館ID1
INSERT INTO lending(user_id,book_id,lend_date,limit_date,returned_date,staff_id) VALUES(2,49,'2024/05/10','2024/05/17','2024/05/20',2); --延滞あり・返却あり・図書館ID2
INSERT INTO lending(user_id,book_id,lend_date,limit_date,returned_date,staff_id) VALUES(2,50,'2024/05/10','2024/05/17','2024/05/20',3); --延滞あり・返却あり・図書館ID3


--予約テーブルデータ
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(1,16,'2024/05/07','2024/05/12',1,1); --図書館1→1
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(1,49,'2024/05/25','2024/06/01',1,1); --図書館1→2
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(1,50,'2024/05/25','2024/06/01',1,1); --図書館1→3
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(2,25,'2024/05/25','2024/06/01',2,1); --図書館2→1
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(2,49,'2024/05/25','2024/06/01',2,1); --図書館2→2
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(2,50,'2024/06/10','2024/06/12',2,1); --図書館2→3
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(3,30,'2024/04/11','2024/04/13',3,1); --図書館3→1
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(3,49,'2024/05/25','2024/06/01',3,1); --図書館3→2
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(3,50,'2024/05/25','2024/06/01',3,1); --図書館3→3
