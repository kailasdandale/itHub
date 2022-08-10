import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FundsubscribebookComponent } from './fundsubscribebook.component';

describe('FundsubscribebookComponent', () => {
  let component: FundsubscribebookComponent;
  let fixture: ComponentFixture<FundsubscribebookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FundsubscribebookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FundsubscribebookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
