import React, { useEffect, useReducer } from 'react';
import axios from 'axios';
import styled from 'styled-components';
import '../../style/gnb.scss';

const GlobalNavStyled = styled.div`
  position: relative;
  background: #483f35;
  z-index: 10;
`;

const reducer = (state, action) => {
  switch (action.type) {
    case 'LOADING':
      return {
        loading: true,
        data: null,
        error: null,
      };
    case 'SUCCESS':
      return {
        loading: false,
        data: action.data,
        error: null,
      };
    case 'ERROR':
      return {
        loading: false,
        data: null,
        error: action.error,
      };
    default:
      return state;
  }
};

const GlobalNav = () => {
  const [state, dispath] = useReducer(reducer, {
    loading: false,
    data: null,
    error: null,
  });

  const fetchMenuList = async () => {
    dispath({ type: 'LOADING' });
    try {
      const response = await axios.get('http://localhost:3000/data/menu.json');
      dispath({ type: 'SUCCESS', data: response.data });
    } catch (e) {
      dispath({ type: 'ERROR', error: e });
    }
  };

  useEffect(() => {
    fetchMenuList();
  }, []);
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
