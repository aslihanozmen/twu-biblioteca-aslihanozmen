-- 1st question
select name
from member
where id IN
      (select member_id
       from checkout_item
       where book_id IN
             (select id from book where title = 'The Hobbit'));
-- Result: Anand Beck


-- 2nd question
select count(*) as people_not_checked_out
from member
where id NOT IN
      (select member_id from checkout_item);
-- Result: 37


-- 3rd question
select title
from book
where id NOT IN
      (select book_id from checkout_item where book_id is not null)
UNION
select title
from movie
where id NOT IN
      (select movie_id from checkout_item where movie_id is not null);
-- Result:
-- 1984
-- Catcher in the Rye
-- Crouching Tiger, Hidden Dragon
-- Domain Driven Design
-- Fellowship of the Ring
-- Lawrence of Arabia
-- Office Space
-- Thin Red Line
-- To Kill a Mockingbird
-- Tom Sawyer


-- 4rd question
insert into book
values (11, 'The Pragmatic Programmer');
insert into member
values (43, 'Asli Ozmen');
insert into checkout_item
values (43, 11, null);

select name
from member
where id IN
      (select member_id
       from checkout_item
       where book_id IN
             (select id from book where title = 'The Pragmatic Programmer'));
-- Result: Asli Ozmen


-- 5th Question
select name
from member
where id IN
      (select member_id
       from checkout_item
       group by member_id
       having count(member_id) > 1);
-- Result:
-- Anand Beck
-- Frank Smith