import React from 'react';
import { NavStyled } from '../styled/Common';
import { MENU } from './menu';
import '../../style/gnb.scss';


const GlobalNav = () => {
  const menuList = MENU;

  return (
    <NavStyled>
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
    </NavStyled>
  );
};

export default GlobalNav;
