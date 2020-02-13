
insert into BOOK (BOOK_ID,NAME,AUTHOR) values (11001,'Feluda','Satyajit Ray');
insert into BOOK (BOOK_ID,NAME,AUTHOR) values (11002,'Byomkesh Omnibus','Saradindu Bandyopadhyay');
insert into COPY (COPY_ID, BOOK_BOOK_ID, AVAILABLE) values (19000,11001,false);
insert into COPY (COPY_ID, BOOK_BOOK_ID, AVAILABLE) values (19001,11001,false);
insert into COPY (COPY_ID, BOOK_BOOK_ID, AVAILABLE) values (19002,11002,false);
insert into COPY (COPY_ID, BOOK_BOOK_ID, AVAILABLE) values (19003,11002,true);
insert into COPY (COPY_ID, BOOK_BOOK_ID, AVAILABLE) values (19004,11001,true);
insert into COPY (COPY_ID, BOOK_BOOK_ID, AVAILABLE) values (19005,11001,true);
insert into BORROWER values (20000,sysdate(),'Shree',19000);
insert into BORROWER values (20001,sysdate(),'Sourav',19001);
insert into BORROWER values (20002,sysdate(),'Sourav',19002);