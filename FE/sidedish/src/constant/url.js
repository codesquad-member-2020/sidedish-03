/* URL
베스트반찬 (Option)
모두 : /best
개별 : /best/{category_id}
밥찬들
모두 : /foodtype/{foodtype_id}

개별 : /foodtype/{foodtype_id}/dish/{dish_id}

든든한 반찬 - foodtype_id : 1

국물요리 - foodtype_id : 2

밑반찬 - foodtype_id : 3

상세페이지
/dish-detail/{dish_id}
*/
const URL = 'https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/';
const MOCK_URL = 'http://localhost:3000/';

export {URL, MOCK_URL}