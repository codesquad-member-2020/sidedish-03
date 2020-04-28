import React from 'react';
import styled from 'styled-components';

const FooterStyled = styled.div`
  padding: 15px 0;
  border-top: 1px solid #e9e9e9;
  background: #fafafa;
`;

const Footer = () => {
  return (
    <FooterStyled className='footer'>
      <div className='inner'>Team#3 Project</div>
    </FooterStyled>
  );
};

export default Footer;
