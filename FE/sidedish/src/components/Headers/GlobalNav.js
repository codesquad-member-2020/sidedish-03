import React from 'react';
import axios from 'axios';
import {NavStyled, Loading} from '../styled/Common';
import useAsync from '../../utils/useAsync';
import { MOCK_URL } from '../../constant/url';
import '../../style/gnb.scss';


const getMenuList = async () => {
  const response = await axios.get(`${MOCK_URL}data/menu.json`);
  return response.data;
};

const GlobalNav = () => {
  const state = useAsync(getMenuList);
  const { loading, data: menuList, error } = state;
  if (loading) return <Loading/>;
  if (error) return <div>에러</div>;
  if (!menuList) return null;

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
