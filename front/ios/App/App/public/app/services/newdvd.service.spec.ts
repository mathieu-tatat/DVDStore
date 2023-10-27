import { TestBed } from '@angular/core/testing';

import { NewdvdService } from './newdvd.service';

describe('NewdvdService', () => {
  let service: NewdvdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewdvdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
