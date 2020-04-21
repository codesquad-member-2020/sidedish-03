import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import '../../style/gnb.scss';

const GlobalNavStyled = styled.div`
  position: relative;
  background: #483f35;
`;

const GlobalNav = () => {
  const [menuList, setMenuList] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    fetch('http://localhost:3000/data/menu.json')
      .then(res => res.json())
      .then(res => {
        setMenuList(res.menu);
        setIsLoading(false);
      });
  }, []);
  return (
    <GlobalNavStyled>
      {isLoading ? (
        <div>로딩</div>
      ) : (
        <div className='inner'>
          <ul className='gnb'>
            {menuList.map(menu => (
              <li key={menu.key}>
                <span>{menu.main.name}</span>
                <ul>
                  {menu.sub.map(v => (
                    <li><span>{v.name}</span></li>
                  ))}
                </ul>
              </li>
            ))}
          </ul>
        </div>
      )}
    </GlobalNavStyled>
  );
};

export default GlobalNav;
