//
//  PaddingLabel.swift
//  SideDish
//
//  Created by Cloud on 2020/04/28.
//  Copyright © 2020 Cloud. All rights reserved.
//

import UIKit



class PaddingLabel: UILabel {
    
    // MARK: - Properties
    typealias Inset = (top: CGFloat, left: CGFloat, right: CGFloat, bottom: CGFloat)
    static let inset: Inset = Inset(1, 2, 2, 1)
    var topInset: CGFloat!
    var leftInset: CGFloat!
    var rightInset: CGFloat!
    var bottomInset: CGFloat!
    override var intrinsicContentSize: CGSize {
        get {
            var contentSize = super.intrinsicContentSize
            contentSize.height += topInset + bottomInset
            contentSize.width += leftInset + rightInset
            return contentSize
        }
    }

    // MARK: - Lifecycle
    required init(insets: Inset = Inset(0, 0, 0, 0)) {
        super.init(frame: CGRect.zero)
        topInset = insets.top
        leftInset = insets.left
        rightInset = insets.right
        bottomInset = insets.bottom
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        basicConfigureInsets()
    }
    
    // MARK: - Methods
    override func drawText(in rect: CGRect) {
        let insets = UIEdgeInsets(top: topInset, left: leftInset, bottom: bottomInset, right: rightInset)
        super.drawText(in: rect.inset(by: insets))
    }
    
    private func basicConfigureInsets() {
        topInset = 0
        leftInset = 0
        rightInset = 0
        bottomInset = 0
    }
}



