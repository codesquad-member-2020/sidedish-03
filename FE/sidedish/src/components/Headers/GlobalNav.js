import React from 'react';
import axios from 'axios';
import styled from 'styled-components';
import useAsync from '../../utils/useAsync';
import { MOCK_URL } from '../../constant/url';
import '../../style/gnb.scss';

const GlobalNavStyled = styled.div`
  position: relative;
  background: #483f35;
  z-index: 10;
`;

const getMenuList = async () => {
  const response = await axios.get(`${MOCK_URL}data/menu.json`);
  return response.data;
};

const GlobalNav = () => {
  const state = useAsync(getMenuList);
  const { loading, data: menuList, error } = state;
  if (loading) return <div>로딩중</div>;
  if (error) return <div>에러</div>;
  if (!menuList) return null;

  return (
    <GlobalNavStyled>
      <div className='inner'>
        <ul className='gnb'>
          {menuList.map(menu => (
            <li key={menu.key}>
              <span>{menu.main.name}</span>
              <ul>
                {menu.sub.map(subMenu => (
                  <li key={subMenu.key}>
                    <span>{subMenu.name}</span>
                  </li>
                ))}
              </ul>
            </li>
          ))}
        </ul>
      </div>
    </GlobalNavStyled>
  );
};

export default GlobalNav;
