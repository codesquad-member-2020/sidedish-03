import React from 'react';
import { IoMdClose } from 'react-icons/io';
import { Mask, CloseButtn } from '../styled/Common';
import Head from './Head';
import Body from './Body';

const Detail = props => {
  const propsData = props.data.item;

  const closeDetail = e => {
    const target = e.currentTarget;
    return props.onClickHandler(target);
  };

  return (
    <Mask className='mask' disappear={props.disappear}>
      <div className='detail-wrap'>
        <Head detailTitle={props.data.title} detailData={propsData} />
        <Body detaileImages={propsData.detailSectionImages} imgAlt={props.data.title} />
      </div>
      <CloseButtn className='btn-close' onClick={closeDetail}>
        <IoMdClose size='50' color='#bfbfbf' />
      </CloseButtn>
    </Mask>
  );
};

export default Detail;
