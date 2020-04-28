import React from 'react';
import styled from 'styled-components';

const TopNavStyled = styled.div`
  border-bottom: 1px solid #eee;
  .inner {
    display: flex;
    justify-content: space-between;
    padding: 10px 0;
  }
  .mem-utils {
    display: flex;
    li {
      position: relative;
    }
    li + li {
      padding-left: 6px;
      margin-left: 5px;
      &::before {
        content: '';
        position: absolute;
        left: 0;
        top: 50%;
        width: 1px;
        height: 10px;
        margin-top: -5px;
        background: #eee;
      }
    }
  }
`;

const TopNav = () => {
  return (
    <TopNavStyled>
      <div className='inner'>
        <span>Team#3 Project</span>
        <ul className='mem-utils'>
          <li><a href='https://github.com/login/oauth/authorize\?client_id=bed01aae4e0ea3bebf24&scope=user%20public_repo'>로그인</a></li>
          <li>회원가입</li>
          <li>마이페이지</li>
          <li>고객센터</li>
          <li>새벽배송 지역검색</li>
          <li>이벤트 게시판</li>
          <li>장바구니</li>
        </ul>
      </div>
    </TopNavStyled>
  );
};

export default TopNav;
