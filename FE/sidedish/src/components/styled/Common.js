import styled, { createGlobalStyle, keyframes, css } from 'styled-components';

const fadeIn = keyframes`
  from { 
    opacity: 0;
  }
  to{
    opacity: 1;
  }
`;

const fadeOut = keyframes`
  from { 
    opacity: 1;
  }
  to{
    opacity: 0;
  }
`;

const slideUp = keyframes`
  from{
    transform: translateY(50px);
  }
  to{
    transform: translateY(0px);
  }
`;

const slideDown = keyframes`
  from{
    transform: translateY(0px);
  }
  to{
    transform: translateY(50px);
  }
`;

const loadingOutter = keyframes`
  from {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  to {
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
`;
const loadingInner = keyframes`
  0% {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(-360deg);
    transform: rotate(-360deg);
  }
`;

const GlobalStyle = createGlobalStyle`
  #wrap {
    overflow: hidden;
    background: #fff;
  }
  .inner {
    width: ${props => props.width};
    margin: 0 auto;
  }
`;

const NavStyled = styled.div`
  position: relative;
  background: #483f35;
  z-index: 10;
`;

const BadgeBox = styled.span`
  display: inline-block;
  padding: 3px 8px;
  border-radius: 5px;
  color: #fff;
  background: ${props => props.backgroundColor};
  & + span {
    margin-left: 5px;
  }
`;

const CloseButtn = styled.div`
  position: absolute;
  top: 50px;
  right: 50px;
  cursor: pointer;
  animation-duration: 0.35s;
  animation-timing-function: ease-out;
  animation-name: ${fadeIn};
  animation-fill-mode: forwards;
  svg {
    pointer-events: none;
    transition: 0.125s all ease-in;
  }
  &:hover {
    svg {
      fill: #2ac1bc;
      transform: rotate(90deg);
    }
  }
  &:active {
    svg {
      fill: #0e8b87;
    }
  }
`;
const Mainloading = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: #fff;
  z-index: 100;
  ${props =>
    props.disappear &&
    css`
      animation-duration: 0.8s;
      animation-timing-function: ease-out;
      animation-name: ${fadeOut};
      animation-fill-mode: forwards;
    `}
  &::before {
    content: 'LOADING';
    font-size: 22px;
  }
  &::after {
    content: 'SIDEDISH TEAM PROJECT';
  }
`;

const Loading = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  position: relative;
  width: 30px;
  height: 30px;
  margin: 30px auto;
  &::before {
    content: '';
    display: block;
    position: absolute;
    border: 4px solid #bdbdbd;
    border-left-color: transparent;
    border-bottom: 0;
    width: 100%;
    height: 100%;
    border-radius: 50%;
    -webkit-animation: ${loadingOutter} 1s cubic-bezier(0.42, 0.61, 0.58, 0.41) infinite;
    animation: ${loadingOutter} 1s cubic-bezier(0.42, 0.61, 0.58, 0.41) infinite;
  }

  &::after {
    content: '';
    display: block;
    position: absolute;
    border: 4px solid #bdbdbd;
    border-radius: 50%;
    width: 40px;
    height: 40px;
    left: calc(50% - 20px);
    top: calc(50% - 20px);
    border-right: 0;
    border-top-color: transparent;
    -webkit-animation: ${loadingInner} 1s cubic-bezier(0.42, 0.61, 0.58, 0.41) infinite;
    animation: ${loadingInner} 1s cubic-bezier(0.42, 0.61, 0.58, 0.41) infinite;
  }
`;

const Mask = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(247, 249, 250, 0.95);
  z-index: 100;
  animation-duration: 0.25s;
  animation-timing-function: ease-out;
  animation-name: ${fadeIn};
  animation-fill-mode: forwards;
  ${props =>
    props.disappear &&
    css`
      animation-name: ${fadeOut};
    `}
  .detail-wrap {
    overflow-y: auto;
    width: 800px;
    height: calc(100% - 100px);
    padding: 20px;
    margin: 50px 0;
    border: 1px solid #eee;
    background: #fff;
    box-shadow: 0 2px 5px rgba(27, 31, 35, 0.1);
    animation-duration: 0.25s;
    animation-timing-function: ease-out;
    animation-name: ${slideUp};
    animation-fill-mode: forwards;
    ${props =>
      props.disappear &&
      css`
        animation-name: ${slideDown};
      `}
  }
  .detail-head {
    display: flex;
    > div {
      width: 50%;
    }
  }
  .detail-thumb {
    .thumb {
      img {
        margin: 0 auto;
      }
    }
    .slick-arrow {
      margin-top: -66px;
    }
    .slick-prev {
      left: 10px;
    }
    .slick-next {
      right: 10px;
    }
    .slick-dots {
      position: relative;
      bottom: 0;
      margin-top: 15px;
      li {
        width: 80px;
        height: 80px;
        img {
          opacity: 0.6;
        }
        &.slick-active {
          outline: 3px solid #2ac1bc;
          img {
            opacity: 1;
          }
        }
      }
    }
  }
  .detail-info {
    display: flex;
    flex-direction: column;
    padding: 0 10px;
    .title {
      margin-bottom: 5px;
      font-weight: bold;
      font-size: 26px;
      line-height: 1.3;
      letter-spacing: -1px;
    }
    .description {
      margin-bottom: 5px;
      font-weight: 300;
      font-size: 14px;
      color: #888;
      line-height: 1.3;
    }
    .table {
      > div {
        display: table;
        margin: 10px 0;
        span {
          display: table-cell;
          line-height: 1.3;
          font-weight: 300;
          color: #888;
        }
        span:first-child {
          width: 100px;
          color: #111;
        }
      }
    }
  }
  .price {
    padding: 5px 0 0;
    text-align: right;
    .item-price {
      del {
        margin-right: 5px;
        color: #888;
      }
      font-weight: bold;
      font-size: 18px;
    }
  }
  .quantity {
    padding: 15px 0;
    margin: 15px 0;
    border-top: 1px solid #111;
    border-bottom: 1px solid #111;
    .quantity-box {
      position: relative;
      button,
      input {
        border: 0;
        text-align: center;
      }
      input {
        width: 100%;
        height: 40px;
        font-weight: bold;
        font-size: 24px;
        border: 1px solid #e0e0e0;
        border-radius: 50px;
      }
      button {
        position: absolute;
        top: 50%;
        width: 40px;
        height: 40px;
        margin-top: -22px;
        font-size: 30px;
        line-height: 0;
        background: transparent;
        z-index: 1;
        cursor: pointer;
        &.btn-minus {
          left: 5px;
        }
        &.btn-plus {
          right: 5px;
        }
        &:focus,
        &:hover {
          outline: none;
        }
      }
    }
  }
  .total {
    display: flex;
    justify-content: space-between;
    align-items: center;
    .tit {
      margin-bottom: 0;
    }
    .total-price {
      span {
        margin-right: 2px;
        font-size: 24px;
      }
      font-weight: bold;
      font-size: 18px;
      color: #2ac1bc;
    }
  }
  .tit {
    margin-bottom: 10px;
    font-size: 16px;
    letter-spacing: -1px;
  }
  .btn-wrap {
    margin-top: auto;
    button {
      width: 100%;
      height: 50px;
      font-size: 24px;
      color: #fff;
      border: 0;
      background: #2ac1bc;
      transition: 0.125s all ease-in;
      cursor: pointer;
      &:focus {
        outline: none;
      }
      &:hover {
        background: #30cec8;
      }
      &:active {
        background: #0e8b87;
      }
    }
  }
  .detail-body {
    margin-top: 50px;
    h3 {
      position: relative;
      padding: 15px 10px;
      font-weight: normal;
      font-size: 16px;
      color: #666;
      border-bottom: 1px solid #ccc;
      background: #f6f6f6;
      &::before {
        /* content: ''; */
        position: absolute;
        left: 0;
        bottom: 0;
        width: 150px;
        height: 1px;
        background: #2ac1bc;
      }
    }
  }
`;

export { GlobalStyle, NavStyled, Mainloading, Loading, BadgeBox, Mask, CloseButtn };
