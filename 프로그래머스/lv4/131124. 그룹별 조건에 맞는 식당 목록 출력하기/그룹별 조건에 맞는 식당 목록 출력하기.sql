select m.member_name, r.review_text, date_format(r.review_date, "%Y-%m-%d") as review_date
from rest_review r
left join member_profile m
using (member_id)
where member_id = (
    select member_id
    from rest_review
    group by member_id
    order by count(*) desc
    limit 1
)
order by r.review_date asc, review_text asc;