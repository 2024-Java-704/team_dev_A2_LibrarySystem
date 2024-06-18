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
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(1,1, 'FACTFULNESS', 'ふぁくとふるねす' ,'ハンス・ロスリング','日経BP', '2019/01/11','2024/01/01',1,1, 1520,'/img/book1.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(1,1, 'FACTFULNESS', 'ふぁくとふるねす' ,'ハンス・ロスリング','日経BP', '2019/01/11','2024/01/01',1,1, 882,'/img/book1.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(1,1, 'FACTFULNESS', 'ふぁくとふるねす' ,'ハンス・ロスリング','日経BP', '2019/01/11','2024/01/01',2,1, 1350,'/img/book1.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(1,1, 'FACTFULNESS', 'ふぁくとふるねす' ,'ハンス・ロスリング','日経BP', '2019/01/11','2024/01/01',2,1, 1125,'/img/book1.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(1,1, 'FACTFULNESS', 'ふぁくとふるねす' ,'ハンス・ロスリング','日経BP', '2019/01/11','2024/01/01',3,1, 1228,'/img/book1.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(1,1, 'FACTFULNESS', 'ふぁくとふるねす' ,'ハンス・ロスリング','日経BP', '2019/01/11','2024/01/01',3,1, 728,'/img/book1.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,2, '哲学と宗教全史', 'てつがくとしゅうきょうぜんし' ,'出口治明','ダイヤモンド社', '2019/08/08','2020/04/01',1,1, 108,'/img/book2.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,2, '哲学と宗教全史', 'てつがくとしゅうきょうぜんし' ,'出口治明','ダイヤモンド社', '2019/08/08','2020/04/01',2,1, 123,'/img/book2.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,2, '哲学と宗教全史', 'てつがくとしゅうきょうぜんし' ,'出口治明','ダイヤモンド社', '2019/08/08','2020/04/01',3,1, 153,'/img/book2.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,3, '世界が面白くなる！身の回りの哲学', 'せかいがおもしろくなる！みのまわりのてつがく' ,'小川仁志','あさ出版', '2022/11/14','2023/04/01',1,1, 123,'/img/book3.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,3, '世界が面白くなる！身の回りの哲学', 'せかいがおもしろくなる！みのまわりのてつがく' ,'小川仁志','あさ出版', '2022/11/14','2023/04/01',2,1, 211,'/img/book3.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,3, '世界が面白くなる！身の回りの哲学', 'せかいがおもしろくなる！みのまわりのてつがく' ,'小川仁志','あさ出版', '2022/11/14','2023/04/01',3,1, 182,'/img/book3.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,4, '14歳からの哲学 考えるための教科書', '14さいからのてつがく かんがえるためのきょうかしょ' ,'池田晶子','トランスビュー', '2003/03/20','2020/04/01',1,1, 230,'/img/book4.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,4, '14歳からの哲学 考えるための教科書', '14さいからのてつがく かんがえるためのきょうかしょ' ,'池田晶子','トランスビュー', '2003/03/20','2020/04/01',2,1, 172,'/img/book4.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,4, '14歳からの哲学 考えるための教科書', '14さいからのてつがく かんがえるためのきょうかしょ' ,'池田晶子','トランスビュー', '2003/03/20','2020/04/01',3,1, 183,'/img/book4.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,5, '世界のエリートが学んでいる教養としての哲学', 'せかいのえりーとがまなんでいるきょうようとしてのてつがく' ,'小川仁志','PHP研究所', '2018/06/01','2020/04/01',1,1, 328,'/img/book5.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,5, '世界のエリートが学んでいる教養としての哲学', 'せかいのえりーとがまなんでいるきょうようとしてのてつがく' ,'小川仁志','PHP研究所', '2018/06/01','2020/04/01',2,1, 186,'/img/book5.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,5, '世界のエリートが学んでいる教養としての哲学', 'せかいのえりーとがまなんでいるきょうようとしてのてつがく' ,'小川仁志','PHP研究所', '2018/06/01','2020/04/01',3,1, 236,'/img/book5.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,6, '哲学用語図鑑', 'てつがくようごずかん' ,'田中正人','プレジデント社', '2015/02/26','2020/04/01',1,1, 83,'/img/book6.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,6, '哲学用語図鑑', 'てつがくようごずかん' ,'田中正人','プレジデント社', '2015/02/26','2020/04/01',2,1, 112,'/img/book6.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,6, '哲学用語図鑑', 'てつがくようごずかん' ,'田中正人','プレジデント社', '2015/02/26','2020/04/01',3,1, 145,'/img/book6.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,7, '飲茶の「最強！」のニーチェ', 'やむちゃの「さいきょう！」のにーちぇ' ,'飲茶','水王社', '2017/11/30','2020/04/01',1,1, 150,'/img/book7.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,7, '飲茶の「最強！」のニーチェ', 'やむちゃの「さいきょう！」のにーちぇ' ,'飲茶','水王社', '2017/11/30','2020/04/01',2,1, 187,'/img/book7.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,7, '飲茶の「最強！」のニーチェ', 'やむちゃの「さいきょう！」のにーちぇ' ,'飲茶','水王社', '2017/11/30','2020/04/01',3,1, 144,'/img/book7.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,8, '西洋哲学史：ルネサンスから現代まで', 'せいようてつがくし：るねさんすからげんだいまで' ,'野田又夫','筑摩書房', '2017/05/10','2020/04/01',1,1, 81,'/img/book8.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,8, '西洋哲学史：ルネサンスから現代まで', 'せいようてつがくし：るねさんすからげんだいまで' ,'野田又夫','筑摩書房', '2017/05/10','2020/04/01',2,1, 132,'/img/book8.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,8, '西洋哲学史：ルネサンスから現代まで', 'せいようてつがくし：るねさんすからげんだいまで' ,'野田又夫','筑摩書房', '2017/05/10','2020/04/01',3,1, 144,'/img/book8.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,9, '方法序説', 'ほうほうじょせつ' ,'谷川多佳子','岩波書店', '1997/07/16','2020/04/01',1,1, 177,'/img/book9.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,9, '方法序説', 'ほうほうじょせつ' ,'谷川多佳子','岩波書店', '1997/07/16','2020/04/01',2,1, 147,'/img/book9.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,9, '方法序説', 'ほうほうじょせつ' ,'谷川多佳子','岩波書店', '1997/07/16','2020/04/01',3,1, 153,'/img/book9.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,10, 'その悩み、哲学者がすでに答えを出しています', 'そのなやみ、てつがくしゃがすでにこたえをだしています' ,'小林昌平','文響社', '2018/04/27','2020/04/01',1,1, 213,'/img/book10.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,10, 'その悩み、哲学者がすでに答えを出しています', 'そのなやみ、てつがくしゃがすでにこたえをだしています' ,'小林昌平','文響社', '2018/04/27','2020/04/01',2,1, 182,'/img/book10.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,10, 'その悩み、哲学者がすでに答えを出しています', 'そのなやみ、てつがくしゃがすでにこたえをだしています' ,'小林昌平','文響社', '2018/04/27','2020/04/01',3,1, 252,'/img/book10.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,11, '武器になる哲学 人生を生き抜くための哲学・思想のキーコンセプト50', 'ぶきになるてつがく じんせいをいきぬくためのてつがく・しそうのきーこんせぷと50' ,'山口周','角川', '2018/05/18','2020/04/01',1,1, 214,'/img/book11.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,11, '武器になる哲学 人生を生き抜くための哲学・思想のキーコンセプト50', 'ぶきになるてつがく じんせいをいきぬくためのてつがく・しそうのきーこんせぷと50' ,'山口周','角川', '2018/05/18','2020/04/01',2,1, 158,'/img/book11.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(2,11, '武器になる哲学 人生を生き抜くための哲学・思想のキーコンセプト50', 'ぶきになるてつがく じんせいをいきぬくためのてつがく・しそうのきーこんせぷと50' ,'山口周','角川', '2018/05/18','2020/04/01',3,1, 192,'/img/book11.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,12, '眠れなくなるほど面白い 図解 孫氏の兵法', 'ねむれなくなるほどおもしろい ずかい そんしのへいほう' ,'島崎晋','日本文芸社', '2019/02/22','2020/04/01',1,1, 287,'/img/book12.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,12, '眠れなくなるほど面白い 図解 孫氏の兵法', 'ねむれなくなるほどおもしろい ずかい そんしのへいほう' ,'島崎晋','日本文芸社', '2019/02/22','2020/04/01',2,1, 342,'/img/book12.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,12, '眠れなくなるほど面白い 図解 孫氏の兵法', 'ねむれなくなるほどおもしろい ずかい そんしのへいほう' ,'島崎晋','日本文芸社', '2019/02/22','2020/04/01',3,1, 330,'/img/book12.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,13, '眠れなくなるほど面白い 図解 論語', 'ねむれなくなるほどおもしろい ずかい ろんご' ,'山口謡司','日本文芸社', '2019/02/22','2020/04/01',1,2, 197,'/img/book13.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,13, '眠れなくなるほど面白い 図解 論語', 'ねむれなくなるほどおもしろい ずかい ろんご' ,'山口謡司','日本文芸社', '2019/02/22','2020/04/01',2,2, 333,'/img/book13.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,13, '眠れなくなるほど面白い 図解 論語', 'ねむれなくなるほどおもしろい ずかい ろんご' ,'山口謡司','日本文芸社', '2019/02/22','2020/04/01',3,2, 278,'/img/book13.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,14, '眠れなくなるほど面白い 図解 神道', 'ねむれなくなるほどおもしろい ずかい しんどう' ,'渋谷申博','日本文芸社', '2020/04/22','2020/07/01',1,1, 230,'/img/book14.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,14, '眠れなくなるほど面白い 図解 神道', 'ねむれなくなるほどおもしろい ずかい しんどう' ,'渋谷申博','日本文芸社', '2020/04/22','2020/07/01',2,1, 343,'/img/book14.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,14, '眠れなくなるほど面白い 図解 神道', 'ねむれなくなるほどおもしろい ずかい しんどう' ,'渋谷申博','日本文芸社', '2020/04/22','2020/07/01',3,1, 375,'/img/book14.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,15, '眠れなくなるほど面白い 図解 ギリシャ神話', 'ねむれなくなるほどおもしろい ずかい ぎりしゃしんわ' ,'島崎晋','日本文芸社', '2020/08/19','2021/04/01',1,1, 184,'/img/book15.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,15, '眠れなくなるほど面白い 図解 ギリシャ神話', 'ねむれなくなるほどおもしろい ずかい ぎりしゃしんわ' ,'島崎晋','日本文芸社', '2020/08/19','2021/04/01',2,1, 223,'/img/book15.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,15, '眠れなくなるほど面白い 図解 ギリシャ神話', 'ねむれなくなるほどおもしろい ずかい ぎりしゃしんわ' ,'島崎晋','日本文芸社', '2020/08/19','2021/04/01',3,1, 263,'/img/book15.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,16, '眠れなくなるほど面白い 図解 仏教', 'ねむれなくなるほどおもしろい ずかい ぶっきょう' ,'渋谷申博','日本文芸社', '2019/07/24','2020/04/01',1,1, 30,'/img/book16.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,16, '眠れなくなるほど面白い 図解 仏教', 'ねむれなくなるほどおもしろい ずかい ぶっきょう' ,'渋谷申博','日本文芸社', '2019/07/24','2020/04/01',2,1, 56,'/img/book16.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(3,16, '眠れなくなるほど面白い 図解 仏教', 'ねむれなくなるほどおもしろい ずかい ぶっきょう' ,'渋谷申博','日本文芸社', '2019/07/24','2020/04/01',3,1, 103,'/img/book16.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,17, '科学の社会史', 'かがくのしゃかいし' ,'古川安','筑摩書房', '2018/10/11','2020/06/01',1,1, 122,'/img/book17.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,17, '科学の社会史', 'かがくのしゃかいし' ,'古川安','筑摩書房', '2018/10/11','2020/06/01',2,1, 243,'/img/book17.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,17, '科学の社会史', 'かがくのしゃかいし' ,'古川安','筑摩書房', '2018/10/11','2020/06/01',3,1, 271,'/img/book17.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,18, '社会科学の哲学入門', 'しゃかいかがくのてつがくにゅうもん' ,'吉田敬','勁草書房', '2021/08/27','2022/04/01',1,1, 230,'/img/book18.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,18, '社会科学の哲学入門', 'しゃかいかがくのてつがくにゅうもん' ,'吉田敬','勁草書房', '2021/08/27','2022/04/01',2,1, 130,'/img/book18.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,18, '社会科学の哲学入門', 'しゃかいかがくのてつがくにゅうもん' ,'吉田敬','勁草書房', '2021/08/27','2022/04/01',2,1, 155,'/img/book18.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,18, '社会科学の哲学入門', 'しゃかいかがくのてつがくにゅうもん' ,'吉田敬','勁草書房', '2021/08/27','2022/04/01',3,1, 242,'/img/book18.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,19, '社会科学の考え方―認識論、リサーチ・デザイン、手法', 'しゃかいかがくのかんがえかた-にんしきろん、りさーちでざいん、しゅほう' ,'野村康','名古屋大学出版会', '2017/05/27','2020/04/01',1,1, 141,'/img/book19.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,19, '社会科学の考え方―認識論、リサーチ・デザイン、手法', 'しゃかいかがくのかんがえかた-にんしきろん、りさーちでざいん、しゅほう' ,'野村康','名古屋大学出版会', '2017/05/27','2020/04/01',2,1, 187,'/img/book19.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,19, '社会科学の考え方―認識論、リサーチ・デザイン、手法', 'しゃかいかがくのかんがえかた-にんしきろん、りさーちでざいん、しゅほう' ,'野村康','名古屋大学出版会', '2017/05/27','2020/04/01',3,1, 163,'/img/book19.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,20, '社会科学のための統計学入門 実例からていねいに学ぶ', 'しゃかいかがくのためのとうけいがくにゅうもん じつれいからていねいにまなぶ' ,'毛塚和宏','講談社', '2022/06/23','2023/04/01',2,1, 194,'/img/book20.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,20, '社会科学のための統計学入門 実例からていねいに学ぶ', 'しゃかいかがくのためのとうけいがくにゅうもん じつれいからていねいにまなぶ' ,'毛塚和宏','講談社', '2022/06/23','2023/04/01',3,1, 127,'/img/book20.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,20, '社会科学のための統計学入門 実例からていねいに学ぶ', 'しゃかいかがくのためのとうけいがくにゅうもん じつれいからていねいにまなぶ' ,'毛塚和宏','講談社', '2022/06/23','2023/04/01',3,1, 84,'/img/book20.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,21, '社会科学のためのデータ分析入門', 'しゃかいかがくのためのでーたぶんせきにゅうもん' ,'今井耕介','岩波書店', '2018/03/13','2020/04/01',1,1, 131,'/img/book21.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,21, '社会科学のためのデータ分析入門', 'しゃかいかがくのためのでーたぶんせきにゅうもん' ,'今井耕介','岩波書店', '2018/03/13','2020/04/01',2,1, 180,'/img/book21.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(4,21, '社会科学のためのデータ分析入門', 'しゃかいかがくのためのでーたぶんせきにゅうもん' ,'今井耕介','岩波書店', '2018/03/13','2020/04/01',3,1, 151,'/img/book21.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,22, '科学の名著50冊が1冊でざっと学べる', 'かがくのめいちょ50さつが1さつでざっとまなべる' ,'西村能一','角川', '2020/09/26','2021/04/01',2,1, 308,'/img/book22.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,22, '科学の名著50冊が1冊でざっと学べる', 'かがくのめいちょ50さつが1さつでざっとまなべる' ,'西村能一','角川', '2020/09/26','2021/04/01',3,1, 180,'/img/book22.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,22, '科学の名著50冊が1冊でざっと学べる', 'かがくのめいちょ50さつが1さつでざっとまなべる' ,'西村能一','角川', '2020/09/26','2021/04/01',3,1, 163,'/img/book22.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,23, '巨大ブラックホールの謎 宇宙最大の「時空の穴」に迫る', 'きょだいぶらっくほーるのなぞ うちゅうさいだいの「じくうのあな」にせまる' ,'本間希樹','講談社', '2017/04/20','2020/04/01',2,1, 240,'/img/book23.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,23, '巨大ブラックホールの謎 宇宙最大の「時空の穴」に迫る', 'きょだいぶらっくほーるのなぞ うちゅうさいだいの「じくうのあな」にせまる' ,'本間希樹','講談社', '2017/04/20','2020/04/01',3,1, 114,'/img/book23.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,23, '巨大ブラックホールの謎 宇宙最大の「時空の穴」に迫る', 'きょだいぶらっくほーるのなぞ うちゅうさいだいの「じくうのあな」にせまる' ,'本間希樹','講談社', '2017/04/20','2020/04/01',3,1, 176,'/img/book23.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,24, '元JAXA研究員も驚いた！ヤバい宇宙図鑑', 'もとJAXAけんきゅういんもおどろいた！やばいうちゅうずかん' ,'谷岡憲隆','青春出版社', '2019/04/23','2020/04/01',1,1, 230,'/img/book24.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,24, '元JAXA研究員も驚いた！ヤバい宇宙図鑑', 'もとJAXAけんきゅういんもおどろいた！やばいうちゅうずかん' ,'谷岡憲隆','青春出版社', '2019/04/23','2020/04/01',2,1, 346,'/img/book24.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,24, '元JAXA研究員も驚いた！ヤバい宇宙図鑑', 'もとJAXAけんきゅういんもおどろいた！やばいうちゅうずかん' ,'谷岡憲隆','青春出版社', '2019/04/23','2020/04/01',3,1, 382,'/img/book24.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,25, '眠れなくなるほど面白い 図解 宇宙の話', 'ねむれなくなるほどおもしろい ずかい うちゅうのはなし' ,'渡部潤一','日本文芸社', '2018/03/17','2020/04/01',1,1, 254,'/img/book25.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,25, '眠れなくなるほど面白い 図解 宇宙の話', 'ねむれなくなるほどおもしろい ずかい うちゅうのはなし' ,'渡部潤一','日本文芸社', '2018/03/17','2020/04/01',2,1, 293,'/img/book25.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,25, '眠れなくなるほど面白い 図解 宇宙の話', 'ねむれなくなるほどおもしろい ずかい うちゅうのはなし' ,'渡部潤一','日本文芸社', '2018/03/17','2020/04/01',3,1, 328,'/img/book25.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,26, '物理学者のすごい思考法', 'ぶつりがくしゃのすごいしこうほう' ,'橋本幸士','集英社インターナショナル', '2021/02/05','2022/04/01',1,1, 130,'/img/book26.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,26, '物理学者のすごい思考法', 'ぶつりがくしゃのすごいしこうほう' ,'橋本幸士','集英社インターナショナル', '2021/02/05','2022/04/01',2,1, 280,'/img/book26.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(5,26, '物理学者のすごい思考法', 'ぶつりがくしゃのすごいしこうほう' ,'橋本幸士','集英社インターナショナル', '2021/02/05','2022/04/01',3,1, 264,'/img/book26.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,27, '生成AIで世界はこう変わる', 'せいせいAIでせかいはこうかわる' ,'今井翔太','SBクリエイティブ', '2024/01/07','2024/03/05',1,1, 380,'/img/book27.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,27, '生成AIで世界はこう変わる', 'せいせいAIでせかいはこうかわる' ,'今井翔太','SBクリエイティブ', '2024/01/07','2024/03/05',2,1, 180,'/img/book27.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,27, '生成AIで世界はこう変わる', 'せいせいAIでせかいはこうかわる' ,'今井翔太','SBクリエイティブ', '2024/01/07','2024/03/05',2,1, 152,'/img/book27.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,27, '生成AIで世界はこう変わる', 'せいせいAIでせかいはこうかわる' ,'今井翔太','SBクリエイティブ', '2024/01/07','2024/03/05',3,1, 164,'/img/book27.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,27, '生成AIで世界はこう変わる', 'せいせいAIでせかいはこうかわる' ,'今井翔太','SBクリエイティブ', '2024/01/07','2024/03/05',3,1, 172,'/img/book27.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,28, '深層学習教科書 ディープラーニング G検定 公式テキスト', 'しんそうがくしゅうきょうかしょ でぃーぷらーにんぐ Gけんてい こうしきてきすと' ,'巣鴨悠輔','翔泳社', '2024/05/27','2024/06/01',1,1, 23,'/img/book28.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,28, '深層学習教科書 ディープラーニング G検定 公式テキスト', 'しんそうがくしゅうきょうかしょ でぃーぷらーにんぐ Gけんてい こうしきてきすと' ,'巣鴨悠輔','翔泳社', '2024/05/27','2024/06/01',2,1, 52,'/img/book28.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,28, '深層学習教科書 ディープラーニング G検定 公式テキスト', 'しんそうがくしゅうきょうかしょ でぃーぷらーにんぐ Gけんてい こうしきてきすと' ,'巣鴨悠輔','翔泳社', '2024/05/27','2024/06/01',3,1, 31,'/img/book28.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,29, 'ホワイトハッカー入門', 'ほわいとはっかーにゅうもん' ,'阿部ひろき','インプレス', '2024/04/18','2024/06/01',1,1, 33,'/img/book29.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,29, 'ホワイトハッカー入門', 'ほわいとはっかーにゅうもん' ,'阿部ひろき','インプレス', '2024/04/18','2024/06/01',2,1, 21,'/img/book29.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,29, 'ホワイトハッカー入門', 'ほわいとはっかーにゅうもん' ,'阿部ひろき','インプレス', '2024/04/18','2024/06/01',3,1, 50,'/img/book29.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,30, 'AWS認定資格試験テキスト AWS認定ソリューションアーキテクト - アソシエイト', 'AWSにんていしかくしけんてきすと AWSにんていそりゅーしょんあーきてくと -あそしえいと' ,'佐々木拓郎','SBクリエイティブ', '2023/09/28','2024/06/01',1,1, 85,'/img/book30.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,30, 'AWS認定資格試験テキスト AWS認定ソリューションアーキテクト - アソシエイト', 'AWSにんていしかくしけんてきすと AWSにんていそりゅーしょんあーきてくと -あそしえいと' ,'佐々木拓郎','SBクリエイティブ', '2023/09/28','2024/06/01',2,1, 165,'/img/book30.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,30, 'AWS認定資格試験テキスト AWS認定ソリューションアーキテクト - アソシエイト', 'AWSにんていしかくしけんてきすと AWSにんていそりゅーしょんあーきてくと -あそしえいと' ,'佐々木拓郎','SBクリエイティブ', '2023/09/28','2024/06/01',2,1,74,'/img/book30.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,30, 'AWS認定資格試験テキスト AWS認定ソリューションアーキテクト - アソシエイト', 'AWSにんていしかくしけんてきすと AWSにんていそりゅーしょんあーきてくと -あそしえいと' ,'佐々木拓郎','SBクリエイティブ', '2023/09/28','2024/06/01',3,1, 173,'/img/book30.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,31, 'ゼロから稼げるChatGPT入門', 'ぜろからかせげるChatGPTにゅうもん' ,'加納敏彦','きずな出版', '2024/03/07','2024/06/01',1,1, 29,'/img/book31.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,31, 'ゼロから稼げるChatGPT入門', 'ぜろからかせげるChatGPTにゅうもん' ,'加納敏彦','きずな出版', '2024/03/07','2024/06/01',2,1, 58,'/img/book31.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,31, 'ゼロから稼げるChatGPT入門', 'ぜろからかせげるChatGPTにゅうもん' ,'加納敏彦','きずな出版', '2024/03/07','2024/06/01',3,1, 38,'/img/book31.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(6,31, 'ゼロから稼げるChatGPT入門', 'ぜろからかせげるChatGPTにゅうもん' ,'加納敏彦','きずな出版', '2024/03/07','2024/06/01',3,1, 18,'/img/book31.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,32, '書いてはいけない-日本経済堕落の真相', 'かいてはいけない-にほんけいざいだらくのしんそう' ,'森永卓郎','フォレスト出版', '2024/03/09','2024/04/01',1,1, 210,'/img/book32.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,32, '書いてはいけない-日本経済堕落の真相', 'かいてはいけない-にほんけいざいだらくのしんそう' ,'森永卓郎','フォレスト出版', '2024/03/09','2024/04/01',2,1, 354,'/img/book32.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,32, '書いてはいけない-日本経済堕落の真相', 'かいてはいけない-にほんけいざいだらくのしんそう' ,'森永卓郎','フォレスト出版', '2024/03/09','2024/04/01',3,1, 140,'/img/book32.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,33, 'さあ、才能に目覚めよう', 'さあ、さいのうにめざめよう' ,'ジム・クリフトン','日経BP', '2023/06/15','2024/04/01',3,1, 105,'/img/book33.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,33, 'さあ、才能に目覚めよう', 'さあ、さいのうにめざめよう' ,'ジム・クリフトン','日経BP', '2023/06/15','2024/04/01',3,1, 140,'/img/book33.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,34, '君のお金は誰のため', 'きみのおかねはだれのため' ,'田内学','東洋経済新報社', '2023/10/18','2024/01/05',2,1, 150,'/img/book34.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,34, '君のお金は誰のため', 'きみのおかねはだれのため' ,'田内学','東洋経済新報社', '2023/10/18','2024/01/05',3,1, 420,'/img/book34.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,34, '君のお金は誰のため', 'きみのおかねはだれのため' ,'田内学','東洋経済新報社', '2023/10/18','2024/01/05',3,1, 360,'/img/book34.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,35, 'サイゼリア元社長が教える 年間客数2億人の経営術', 'さいぜりあもとしゃちょうがおしえる ねんかんきゃくすう2おくにんのけいえいじゅつ' ,'堀杢一成','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',1,1, 130,'/img/book35.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,35, 'サイゼリア元社長が教える 年間客数2億人の経営術', 'さいぜりあもとしゃちょうがおしえる ねんかんきゃくすう2おくにんのけいえいじゅつ' ,'堀杢一成','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',2,1, 344,'/img/book35.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,35, 'サイゼリア元社長が教える 年間客数2億人の経営術', 'さいぜりあもとしゃちょうがおしえる ねんかんきゃくすう2おくにんのけいえいじゅつ' ,'堀杢一成','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',3,1, 279,'/img/book35.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,36, 'ほったらかし投資術', 'ほったらかしとうしじゅつ' ,'山崎元','朝日新聞出版', '2022/03/11','2024/04/01',1,1, 100,'/img/book36.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,36, 'ほったらかし投資術', 'ほったらかしとうしじゅつ' ,'山崎元','朝日新聞出版', '2022/03/11','2024/04/01',2,1, 211,'/img/book36.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,36, 'ほったらかし投資術', 'ほったらかしとうしじゅつ' ,'山崎元','朝日新聞出版', '2022/03/11','2024/04/01',3,1, 230,'/img/book36.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,37, '図解・最新 難しいことはわかりませんが、お金の増やし方を教えてください', 'ずかい・さいしん むずかしいことはわかりませんが、おかねのふやしかたをおしえてください' ,'山崎元','文響社', '2017/11/29','2020/04/01',1,1, 110,'/img/book37.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,37, '図解・最新 難しいことはわかりませんが、お金の増やし方を教えてください', 'ずかい・さいしん むずかしいことはわかりませんが、おかねのふやしかたをおしえてください' ,'山崎元','文響社', '2017/11/29','2020/04/01',1,1, 230,'/img/book37.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,37, '図解・最新 難しいことはわかりませんが、お金の増やし方を教えてください', 'ずかい・さいしん むずかしいことはわかりませんが、おかねのふやしかたをおしえてください' ,'山崎元','文響社', '2017/11/29','2020/04/01',2,1, 540,'/img/book37.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,37, '図解・最新 難しいことはわかりませんが、お金の増やし方を教えてください', 'ずかい・さいしん むずかしいことはわかりませんが、おかねのふやしかたをおしえてください' ,'山崎元','文響社', '2017/11/29','2020/04/01',2,1, 345,'/img/book37.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,37, '図解・最新 難しいことはわかりませんが、お金の増やし方を教えてください', 'ずかい・さいしん むずかしいことはわかりませんが、おかねのふやしかたをおしえてください' ,'山崎元','文響社', '2017/11/29','2020/04/01',2,1, 465,'/img/book37.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(7,37, '図解・最新 難しいことはわかりませんが、お金の増やし方を教えてください', 'ずかい・さいしん むずかしいことはわかりませんが、おかねのふやしかたをおしえてください' ,'山崎元','文響社', '2017/11/29','2020/04/01',3,1, 174,'/img/book37.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,38, '世界でいちばん素敵な西洋美術の教室', 'せかいでいちばんすてきなせいようびじゅｙつのきょうかしょ' ,'永井龍之介','三才ブックス', '2018/10/04','2019/07/30',1,1, 68,'/img/book38.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,38, '世界でいちばん素敵な西洋美術の教室', 'せかいでいちばんすてきなせいようびじゅｙつのきょうかしょ' ,'永井龍之介','三才ブックス', '2018/10/04','2019/07/30',2,1, 338,'/img/book38.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,38, '世界でいちばん素敵な西洋美術の教室', 'せかいでいちばんすてきなせいようびじゅｙつのきょうかしょ' ,'永井龍之介','三才ブックス', '2018/10/04','2019/07/30',2,1, 272,'/img/book38.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,39, '東京藝大で教わる西洋美術の見かた', 'とうきょうげいだいでおそわるせいようびじゅつのみかた' ,'佐藤直樹','世界文化社', '2021/01/27','2021/07/30',2,1, 214,'/img/book39.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,39, '東京藝大で教わる西洋美術の見かた', 'とうきょうげいだいでおそわるせいようびじゅつのみかた' ,'佐藤直樹','世界文化社', '2021/01/27','2021/07/30',3,1, 380,'/img/book39.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,40, '大学4年間の西洋美術史が10時間でざっと学べる', 'だいがく4ねんかんのせいようびじゅつしが10じかんでざっとまなべる' ,'池上英洋','世界文化社', '2020/07/16','2021/07/30',2,1, 125,'/img/book40.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,40, '大学4年間の西洋美術史が10時間でざっと学べる', 'だいがく4ねんかんのせいようびじゅつしが10じかんでざっとまなべる' ,'池上英洋','世界文化社', '2020/07/16','2021/07/30',3,1, 138,'/img/book40.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,41, 'いちばん親切な西洋美術史', 'いちばんしんせつなせいようびじゅつし' ,'池上英洋','新星出版社', '2016/07/15','2021/07/30',2,1, 80,'/img/book41.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,41, 'いちばん親切な西洋美術史', 'いちばんしんせつなせいようびじゅつし' ,'池上英洋','新星出版社', '2016/07/15','2021/07/30',3,1, 180,'/img/book41.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,42, '「自分だけの答え」が見つかる13歳からのアート思考', '「じぶんだけのこたえ」がみつかる13さいからのあーとしこう' ,'末永幸歩','ダイヤモンド社', '2020/02/20','2021/07/30',1,1, 350,'/img/book42.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,42, '「自分だけの答え」が見つかる13歳からのアート思考', '「じぶんだけのこたえ」がみつかる13さいからのあーとしこう' ,'末永幸歩','ダイヤモンド社', '2020/02/20','2021/07/30',2,1, 234,'/img/book42.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(8,42, '「自分だけの答え」が見つかる13歳からのアート思考', '「じぶんだけのこたえ」がみつかる13さいからのあーとしこう' ,'末永幸歩','ダイヤモンド社', '2020/02/20','2021/07/30',3,1, 324,'/img/book42.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,43, '「何回説明しても伝わらない」はなぜ起こるのか？認知科学が教えるコミュニケーションの本質と解決策', '「なんかいせつめいしてもつたわらない」はなぜおこるのか？にんちかがくがおしえるこみゅにけーしょんのほんしつとかいけつさく' ,'今井むつみ','日経BP', '2024/05/09','2024/06/01',1,1, 7,'/img/book43.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,43, '「何回説明しても伝わらない」はなぜ起こるのか？認知科学が教えるコミュニケーションの本質と解決策', '「なんかいせつめいしてもつたわらない」はなぜおこるのか？にんちかがくがおしえるこみゅにけーしょんのほんしつとかいけつさく' ,'今井むつみ','日経BP', '2024/05/09','2024/06/01',3,1, 13,'/img/book43.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,43, '「何回説明しても伝わらない」はなぜ起こるのか？認知科学が教えるコミュニケーションの本質と解決策', '「なんかいせつめいしてもつたわらない」はなぜおこるのか？にんちかがくがおしえるこみゅにけーしょんのほんしつとかいけつさく' ,'今井むつみ','日経BP', '2024/05/09','2024/06/01',3,1, 25,'/img/book43.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,44, '漢検3級 過去問題集', 'かんけん3きゅう　かこもんだいしゅう' ,'','日本漢字能力検定協会', '2023/03/27','2023/08/30',1,1, 72,'/img/book44.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,44, '漢検3級 過去問題集', 'かんけん3きゅう　かこもんだいしゅう' ,'','日本漢字能力検定協会', '2023/03/27','2023/08/30',2,1, 123,'/img/book44.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,44, '漢検3級 過去問題集', 'かんけん3きゅう　かこもんだいしゅう' ,'','日本漢字能力検定協会', '2023/03/27','2023/08/30',3,1, 230,'/img/book44.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,45, '世界の一流は「雑談」で何を話しているのか', 'せかいのいちりゅうは「ざつだん」でなにをはなしているのか' ,'ピョートル・フェリクス・グジバチ','クロスメディア・パブリッシング', '2023/03/31','2023/07/30',1,1, 1230,'/img/book45.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,45, '世界の一流は「雑談」で何を話しているのか', 'せかいのいちりゅうは「ざつだん」でなにをはなしているのか' ,'ピョートル・フェリクス・グジバチ','クロスメディア・パブリッシング', '2023/03/31','2023/07/30',1,1, 520,'/img/book45.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,45, '世界の一流は「雑談」で何を話しているのか', 'せかいのいちりゅうは「ざつだん」でなにをはなしているのか' ,'ピョートル・フェリクス・グジバチ','クロスメディア・パブリッシング', '2023/03/31','2023/07/30',2,1, 1320,'/img/book45.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,45, '世界の一流は「雑談」で何を話しているのか', 'せかいのいちりゅうは「ざつだん」でなにをはなしているのか' ,'ピョートル・フェリクス・グジバチ','クロスメディア・パブリッシング', '2023/03/31','2023/07/30',2,1, 720,'/img/book45.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,45, '世界の一流は「雑談」で何を話しているのか', 'せかいのいちりゅうは「ざつだん」でなにをはなしているのか' ,'ピョートル・フェリクス・グジバチ','クロスメディア・パブリッシング', '2023/03/31','2023/07/30',3,1, 1100,'/img/book45.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,46, 'TOEIC L&R TEST はじめから超特急 金のパッケージ', 'TOEIC L&R TEST はじめから ちょうとっきゅう きんのぱっけーじ' ,'TEX 加藤','朝日新聞出版社', '2024/01/19','2024/03/03',1,1, 520,'/img/book46.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,46, 'TOEIC L&R TEST はじめから超特急 金のパッケージ', 'TOEIC L&R TEST はじめから ちょうとっきゅう きんのぱっけーじ' ,'TEX 加藤','朝日新聞出版社', '2024/01/19','2024/03/03',1,1, 380,'/img/book46.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,46, 'TOEIC L&R TEST はじめから超特急 金のパッケージ', 'TOEIC L&R TEST はじめから ちょうとっきゅう きんのぱっけーじ' ,'TEX 加藤','朝日新聞出版社', '2024/01/19','2024/03/03',2,1, 270,'/img/book46.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,46, 'TOEIC L&R TEST はじめから超特急 金のパッケージ', 'TOEIC L&R TEST はじめから ちょうとっきゅう きんのぱっけーじ' ,'TEX 加藤','朝日新聞出版社', '2024/01/19','2024/03/03',2,1, 584,'/img/book46.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,46, 'TOEIC L&R TEST はじめから超特急 金のパッケージ', 'TOEIC L&R TEST はじめから ちょうとっきゅう きんのぱっけーじ' ,'TEX 加藤','朝日新聞出版社', '2024/01/19','2024/03/03',3,1, 973,'/img/book46.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,47, 'はじめて受けるTOEIC L&Rテスト 全パート完全攻略', 'はじめてうけるTOEIC L&Rてすと ぜんぱーとかんぜんこうりゃく' ,'小石裕子','アルク', '2018/03/07','2021/07/30',1,1, 518,'/img/book47.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,47, 'はじめて受けるTOEIC L&Rテスト 全パート完全攻略', 'はじめてうけるTOEIC L&Rてすと ぜんぱーとかんぜんこうりゃく' ,'小石裕子','アルク', '2018/03/07','2021/07/30',1,1, 388,'/img/book47.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,47, 'はじめて受けるTOEIC L&Rテスト 全パート完全攻略', 'はじめてうけるTOEIC L&Rてすと ぜんぱーとかんぜんこうりゃく' ,'小石裕子','アルク', '2018/03/07','2021/07/30',2,1, 638,'/img/book47.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,47, 'はじめて受けるTOEIC L&Rテスト 全パート完全攻略', 'はじめてうけるTOEIC L&Rてすと ぜんぱーとかんぜんこうりゃく' ,'小石裕子','アルク', '2018/03/07','2021/07/30',2,1, 438,'/img/book47.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(9,47, 'はじめて受けるTOEIC L&Rテスト 全パート完全攻略', 'はじめてうけるTOEIC L&Rてすと ぜんぱーとかんぜんこうりゃく' ,'小石裕子','アルク', '2018/03/07','2021/07/30',3,1, 1028,'/img/book47.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,48, '東大発！1万人の子供が変わった ハマるおうち読書', 'とうだいはつ！1まんにんのこどもがかわった はまるおうちどくしょ' ,'笹沼颯太','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',1,1, 880,'/img/book48.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,48, '東大発！1万人の子供が変わった ハマるおうち読書', 'とうだいはつ！1まんにんのこどもがかわった はまるおうちどくしょ' ,'笹沼颯太','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',1,1, 563,'/img/book48.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,48, '東大発！1万人の子供が変わった ハマるおうち読書', 'とうだいはつ！1まんにんのこどもがかわった はまるおうちどくしょ' ,'笹沼颯太','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',1,1, 730,'/img/book48.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,48, '東大発！1万人の子供が変わった ハマるおうち読書', 'とうだいはつ！1まんにんのこどもがかわった はまるおうちどくしょ' ,'笹沼颯太','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',2,1, 580,'/img/book48.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,48, '東大発！1万人の子供が変わった ハマるおうち読書', 'とうだいはつ！1まんにんのこどもがかわった はまるおうちどくしょ' ,'笹沼颯太','ディスカバー・トゥエンティワン', '2024/05/24','2024/06/01',3,1, 280,'/img/book48.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,49, '世界で活躍する子の英語力の育て方', 'せかいでかつやくするこのえいごりょくのそだてかた' ,'船津徹','大和書房', '2019/06/20','2021/07/30',1,1, 625,'/img/book49.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,49, '世界で活躍する子の英語力の育て方', 'せかいでかつやくするこのえいごりょくのそだてかた' ,'船津徹','大和書房', '2019/06/20','2021/07/30',1,1, 523,'/img/book49.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,49, '世界で活躍する子の英語力の育て方', 'せかいでかつやくするこのえいごりょくのそだてかた' ,'船津徹','大和書房', '2019/06/20','2021/07/30',2,1, 358,'/img/book49.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,49, '世界で活躍する子の英語力の育て方', 'せかいでかつやくするこのえいごりょくのそだてかた' ,'船津徹','大和書房', '2019/06/20','2021/07/30',3,1, 235,'/img/book49.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,50, '傲慢と善良', 'ごうまんとぜんりょう' ,'辻村深月','朝日新聞出版', '2022/09/07','2022/10/30',1,1, 120,'/img/book50.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,50, '傲慢と善良', 'ごうまんとぜんりょう' ,'辻村深月','朝日新聞出版', '2022/09/07','2022/10/30',3,1, 320,'/img/book50.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,51, 'コンビニ人間', 'こんびににんげん' ,'村田沙耶香','文藝春秋', '2018/09/04','2021/07/30',1,1,242,'/img/book51.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,51,'コンビニ人間', 'こんびににんげん' ,'村田沙耶香','文藝春秋', '2018/09/04','2021/07/30',2,1,211,'/img/book51.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,51,'コンビニ人間', 'こんびににんげん' ,'村田沙耶香','文藝春秋', '2018/09/04','2021/07/30',2,1,136,'/img/book51.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,52, 'アリス殺し', 'ありすごろし' ,'小林泰三','東京創元社', '2019/04/24','2021/07/30',1,1, 320,'/img/book52.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,52, 'アリス殺し', 'ありすごろし' ,'小林泰三','東京創元社', '2019/04/24','2021/07/30',2,1, 233,'/img/book52.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,52, 'アリス殺し', 'ありすごろし' ,'小林泰三','東京創元社', '2019/04/24','2021/07/30',3,1, 126,'/img/book52.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,52, 'アリス殺し', 'ありすごろし' ,'小林泰三','東京創元社', '2019/04/24','2021/07/30',3,1, 360,'/img/book52.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(10,52, 'アリス殺し', 'ありすごろし' ,'小林泰三','東京創元社', '2019/04/24','2021/07/30',3,1, 255,'/img/book52.jpg');


INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,53, '鬼滅の刃 10巻', 'きめつのやいば 10かん' ,'吾峠呼世晴','集英社', '2018/03/02','2020/04/01',1,1, 355,'/img/book53.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,53, '鬼滅の刃 10巻', 'きめつのやいば 10かん' ,'吾峠呼世晴','集英社', '2018/03/02','2020/04/01',1,1, 860,'/img/book53.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,53, '鬼滅の刃 10巻', 'きめつのやいば 10かん' ,'吾峠呼世晴','集英社', '2018/03/02','2020/04/01',2,1, 556,'/img/book53.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,53, '鬼滅の刃 10巻', 'きめつのやいば 10かん' ,'吾峠呼世晴','集英社', '2018/03/02','2020/04/01',2,1, 150,'/img/book53.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,53, '鬼滅の刃 10巻', 'きめつのやいば 10かん' ,'吾峠呼世晴','集英社', '2018/03/02','2020/04/01',3,1, 620,'/img/book53.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,53, '鬼滅の刃 10巻', 'きめつのやいば 10かん' ,'吾峠呼世晴','集英社', '2018/03/02','2020/04/01',3,1, 982,'/img/book53.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,54, 'one－piece 108巻', 'one－piece 108かん' ,'尾田栄一郎','集英社', '2024/03/04','2024/04/01',1,1, 35,'/img/book54.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,54, 'one－piece 108巻', 'one－piece 108かん' ,'尾田栄一郎','集英社', '2024/03/04','2024/04/01',1,1, 28,'/img/book54.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,54, 'one－piece 108巻', 'one－piece 108かん' ,'尾田栄一郎','集英社', '2024/03/04','2024/04/01',2,1, 44,'/img/book54.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,54, 'one－piece 108巻', 'one－piece 108かん' ,'尾田栄一郎','集英社', '2024/03/04','2024/04/01',2,1, 32,'/img/book54.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,54, 'one－piece 108巻', 'one－piece 108かん' ,'尾田栄一郎','集英社', '2024/03/04','2024/04/01',3,1, 68,'/img/book54.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,54, 'one－piece 108巻', 'one－piece 108かん' ,'尾田栄一郎','集英社', '2024/03/04','2024/04/01',3,1, 57,'/img/book54.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,55, '呪術廻戦 1巻', 'じゅじゅつかいせん 1かん' ,'芥見下々','集英社', '2018/07/04','2020/04/01',1,1, 255,'/img/book55.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,55, '呪術廻戦 1巻', 'じゅじゅつかいせん 1かん' ,'芥見下々','集英社', '2018/07/04','2020/04/01',1,1, 380,'/img/book55.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,55, '呪術廻戦 1巻', 'じゅじゅつかいせん 1かん' ,'芥見下々','集英社', '2018/07/04','2020/04/01',2,1, 288,'/img/book55.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,55, '呪術廻戦 1巻', 'じゅじゅつかいせん 1かん' ,'芥見下々','集英社', '2018/07/04','2020/04/01',2,1, 238,'/img/book55.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,55, '呪術廻戦 1巻', 'じゅじゅつかいせん 1かん' ,'芥見下々','集英社', '2018/07/04','2020/04/01',3,1, 322,'/img/book55.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,55, '呪術廻戦 1巻', 'じゅじゅつかいせん 1かん' ,'芥見下々','集英社', '2018/07/04','2020/04/01',3,1, 347,'/img/book55.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,56, '名探偵コナン 105巻', 'めいたんていこなん 105かん' ,'青山剛昌','小学館', '2024/04/10','2024/05/01',1,1, 25,'/img/book56.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,56, '名探偵コナン 105巻', 'めいたんていこなん 105かん' ,'青山剛昌','小学館', '2024/04/10','2024/05/01',1,1, 27,'/img/book56.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,56, '名探偵コナン 105巻', 'めいたんていこなん 105かん' ,'青山剛昌','小学館', '2024/04/10','2024/05/01',2,1, 13,'/img/book56.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,56, '名探偵コナン 105巻', 'めいたんていこなん 105かん' ,'青山剛昌','小学館', '2024/04/10','2024/05/01',2,1, 15,'/img/book56.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,56, '名探偵コナン 105巻', 'めいたんていこなん 105かん' ,'青山剛昌','小学館', '2024/04/10','2024/05/01',3,1, 18,'/img/book56.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,56, '名探偵コナン 105巻', 'めいたんていこなん 105かん' ,'青山剛昌','小学館', '2024/04/10','2024/05/01',3,1, 21,'/img/book56.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,57, '薬屋のひとりごと 1巻', 'くすりやのひとりごと 1かん' ,'日向夏','スクウェア・エニックス', '2017/09/25','2020/04/01',1,1, 239,'/img/book57.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,57, '薬屋のひとりごと 1巻', 'くすりやのひとりごと 1かん' ,'日向夏','スクウェア・エニックス', '2017/09/25','2020/04/01',1,1, 251,'/img/book57.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,57, '薬屋のひとりごと 1巻', 'くすりやのひとりごと 1かん' ,'日向夏','スクウェア・エニックス', '2017/09/25','2020/04/01',2,1, 320,'/img/book57.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,57, '薬屋のひとりごと 1巻', 'くすりやのひとりごと 1かん' ,'日向夏','スクウェア・エニックス', '2017/09/25','2020/04/01',2,1, 355,'/img/book57.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,57, '薬屋のひとりごと 1巻', 'くすりやのひとりごと 1かん' ,'日向夏','スクウェア・エニックス', '2017/09/25','2020/04/01',3,1, 417,'/img/book57.jpg');
INSERT INTO book(category_id,title_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt,img) VALUES(11,57, '薬屋のひとりごと 1巻', 'くすりやのひとりごと 1かん' ,'日向夏','スクウェア・エニックス', '2017/09/25','2020/04/01',3,1, 376,'/img/book57.jpg');


--図書館テーブルデータ
INSERT INTO library(name,address,tel) VALUES('港区図書館','東京都港区','03-1111-2222');
INSERT INTO library(name,address,tel) VALUES('品川区図書館','東京都品川区','03-1111-3333');
INSERT INTO library(name,address,tel) VALUES('千代田区図書館','東京都千代田区','03-1111-4444');
--ステータステーブルデータ
INSERT INTO status(name) VALUES('予約中');
INSERT INTO status(name) VALUES('予約キャンセル');
INSERT INTO status(name) VALUES('注文中');
INSERT INTO status(name) VALUES('発送済み');
INSERT INTO status(name) VALUES('到着済み');
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
INSERT INTO lending(user_id,book_id,lend_date,limit_date,staff_id) VALUES(1,40,'2024/06/14','2024/06/21',1); --貸出中用


--予約テーブルデータ
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(1,16,'2024/05/07','2024/05/12',1,1); --図書館1→1
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(1,49,'2024/05/25','2024/06/01',1,3); --図書館1→2
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(1,50,'2024/05/25','2024/06/01',1,3); --図書館1→3
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(2,25,'2024/05/25','2024/06/01',2,3); --図書館2→1
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(2,49,'2024/05/25','2024/06/01',2,1); --図書館2→2
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(2,50,'2024/06/10','2024/06/12',2,3); --図書館2→3
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(3,30,'2024/04/11','2024/04/13',3,3); --図書館3→1
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(3,49,'2024/05/25','2024/06/01',3,3); --図書館3→2
INSERT INTO reservation(user_id,book_id,reservation_date,scheduled_date,library_id,status_id) VALUES(3,50,'2024/05/25','2024/06/01',3,1); --図書館3→3
