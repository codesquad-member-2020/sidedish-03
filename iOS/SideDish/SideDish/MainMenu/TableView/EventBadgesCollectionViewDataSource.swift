//
//  EventBadgesCollectionViewDataSource.swift
//  SideDish
//
//  Created by Cloud on 2020/04/20.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit

class EventBadgesCollectionViewDataSource: NSObject {
    var badges: [String] = ["마감임박",
                            "한정세일",
                            "한정세일한정세일",
                            "한정세일한정세일한정세일",]
}

extension EventBadgesCollectionViewDataSource: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return badges.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        guard let cell =
            collectionView.dequeueReusableCell(withReuseIdentifier: EventBadgesCollectionViewCell.identifier,
                                               for: indexPath) as? EventBadgesCollectionViewCell else {
                                                return UICollectionViewCell()
        }
        cell.apply(badges[indexPath.item])
        return cell
    }
}
