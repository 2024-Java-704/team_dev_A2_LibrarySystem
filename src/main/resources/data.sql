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
-- 本テーブルデータ
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(1, 'FACTFULNESS', 'ふぁくとふるねす' ,'ハンス・ロスリング','日経BP', '2019/01/11','2024/01/01',1,1, 100);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '眠れなくなるほど面白い 図解 宇宙の話', 'ねむれなくなるほどおもしろい ずかい うちゅうのはなし' ,'渡部潤一','日本文芸社', '2018/03/30','2024/01/03',2,1, 200);
INSERT INTO book(category_id,title,hurigana,author,publisher,pub_year,reg_day,library_id,condition_id,cnt) VALUES(2, '君のお金は誰のため', 'きみのおかねはだれのため' ,'田内学','東洋経済新報社', '2023/10/18','2024/01/05',3,1, 150);
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
INSERT INTO user(name,email,address,tel,password) VALUES('田中太郎','tanaka@mail.com','東京都大田区','090-1111-5555','aaa');
INSERT INTO user(name,email,address,tel,password) VALUES('佐藤一郎','tanaka@mail.com','東京都大田区','090-1111-5555','aaa');