import React from 'react';
import axios from 'axios';
import useAsync from '../../utils/useAsync';
import { URL } from '../../constant/url';
import { Loading } from '../styled/Common';
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import Item from '../Item';
import '../../style/tabs.scss';

export default props => {
  const onClickTest = (item, title) => {
    return props.onClickHandler(item, title);
  };
  const getData = async () => {
    const response = await axios(`${URL}${props.url}`);
    return response;
  };
  const state = useAsync(getData);

  const { loading, data: bestItems, error } = state;
  if (loading) return <Loading />;
  if (error) return <div>에러</div>;
  if (!bestItems) return null;

  return (
    <>
      {bestItems && (
        <Tabs className='tab-wrap'>
          <div className='inner'>
            <p className='tab-title'>
              <span>베스트셀러</span>
              후기가 증명하는 베스트셀러
            </p>
            <TabList className='tab-nav'>
              {bestItems.data.map((cate, index) => (
                <Tab key={index}>{cate.categoryName}</Tab>
              ))}
            </TabList>
            {bestItems.data.map((itemList, index) => {
              const sliceData = itemList.items.slice(0, 4);
              return (
                <TabPanel key={index} className='tab-panel'>
                  {sliceData.map((item, i) => {
                    return <Item key={i} data={item} onClickHandler={onClickTest} />;
                  })}
                </TabPanel>
              );
            })}
          </div>
        </Tabs>
      )}
    </>
  );
};
