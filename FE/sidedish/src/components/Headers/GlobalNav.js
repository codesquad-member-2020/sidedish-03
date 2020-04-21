import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styled from 'styled-components';
import '../../style/gnb.scss';

const GlobalNavStyled = styled.div`
  position: relative;
  background: #483f35;
`;

const GlobalNav = () => {
  const [menuList, setMenuList] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchMenuList = async () => {
      try {
        setMenuList(null);
        setError(null);
        setLoading(true);
        const response = await axios.get('http://localhost:3000/data/menu.json');
        setMenuList(response.data.menu);
      } catch (e) {
        setError(e);
      }
      setLoading(false);
    };
    fetchMenuList();
  }, []);

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
